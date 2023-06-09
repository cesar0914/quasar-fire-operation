package co.com.mercadolibre.quasarfireoperation.service.impl;

import co.com.mercadolibre.quasarfireoperation.exception.InternalServerErrorException;
import co.com.mercadolibre.quasarfireoperation.exception.NotFoundException;
import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import co.com.mercadolibre.quasarfireoperation.model.dto.response.TopSecretResponse;
import co.com.mercadolibre.quasarfireoperation.model.entity.Satellite;
import co.com.mercadolibre.quasarfireoperation.repository.SatelliteRepository;
import co.com.mercadolibre.quasarfireoperation.service.TopSecretService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static co.com.mercadolibre.quasarfireoperation.utils.TopSecretConstant.*;

@Log4j2
@Service
@RequiredArgsConstructor
public class TopSecretServiceImpl implements TopSecretService {

    private final SatelliteRepository satelliteRepository;
    private final ModelMapper mapper;

    public Point getLocation(double[] distances) {
        log.info("Getting location");
        if (distances.length < 3) {
            throw new NotFoundException(NOT_FOUND_POSITION_ERROR);
        }

        double x1 = KENOBI_POSITION.getX();
        double y1 = KENOBI_POSITION.getY();
        double d1 = distances[0];

        double x2 = SKYWALKER_POSITION.getX();
        double y2 = SKYWALKER_POSITION.getY();
        double d2 = distances[1];

        double x3 = SATO_POSITION.getX();
        double y3 = SATO_POSITION.getY();
        double d3 = distances[2];

        // Calcular las coordenadas 'x' e 'y' del emisor del mensaje

        double A = 2 * (x2 - x1);
        double B = 2 * (y2 - y1);
        double C = Math.pow(d1, 2) - Math.pow(d2, 2) - Math.pow(x1, 2) + Math.pow(x2, 2) - Math.pow(y1, 2) + Math.pow(y2, 2);
        double D = 2 * (x3 - x2);
        double E = 2 * (y3 - y2);
        double F = Math.pow(d2, 2) - Math.pow(d3, 2) - Math.pow(x2, 2) + Math.pow(x3, 2) - Math.pow(y2, 2) + Math.pow(y3, 2);

        double denominator = B * D - A * E;

        if (denominator == 0) {
            throw new NotFoundException(NOT_FOUND_POSITION_ERROR);
        }

        double x = (C * E - F * B) / denominator;
        double y = (C * D - A * F) / denominator;

        return new Point((int) x, (int) y);

    }

    public String getMessage(String[][] messages) {
        log.info("Getting message");
        LinkedList<String> result = new LinkedList<>();
        int maxLength = 0;

        for (String[] message : messages) {
            maxLength = Math.max(maxLength, message.length);
        }

        for (int i = 0; i < maxLength; i++) {
            result.add("");
        }

        for (String[] strings : messages) {
            for (int j = 0; j < strings.length; j++) {
                if (!strings[j].isEmpty() && result.get(j).isEmpty()) {
                    result.set(j, strings[j]);
                }
            }
        }

        if (result.contains("")){
            throw new NotFoundException(NOT_FOUND_MESSAGE_ERROR);
        }

        return String.join(" ", result);
    }

    @Override
    public TopSecretResponse getTopSecret(List<SatelliteDto> satellites) {
        log.info("Getting top secret info");
        double[] distances;
        String[][] messages;
        Point location;
        String message;

        try {
            distances = satellites.stream().mapToDouble(SatelliteDto::getDistance).toArray();
            messages = satellites.stream().map(SatelliteDto::getMessage).toArray(String[][]::new);
            location = getLocation(distances);
            message = getMessage(messages);
        }catch (NotFoundException nfe){
            log.error(nfe.getMessage());
            throw new NotFoundException(nfe.getMessage());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new InternalServerErrorException(INTERNAL_SERVER_ERROR);
        }

        return TopSecretResponse.builder().position(location).message(message).build();
    }

    @Override
    public void updateSatelliteData(String satelliteName, SatelliteDto satelliteDto) {
        log.info("Updating satellite data");

        try {
            Satellite existingSatellite = satelliteRepository.findByName(satelliteName);
            if (existingSatellite == null) {
                Satellite satellite = new Satellite();
                satellite.setName(satelliteName);
                satellite.setDistance(satelliteDto.getDistance());
                satellite.setMessage(satelliteDto.getMessage());
                satelliteRepository.save(satellite);
            } else {
                existingSatellite.setDistance(satelliteDto.getDistance());
                satelliteRepository.save(existingSatellite);
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new InternalServerErrorException(INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public TopSecretResponse getTopSecretSplit() {
        log.info("Getting top secret split");
        List<SatelliteDto> satelliteDtoList;
        List<Satellite> satelliteList = satelliteRepository.findAll();
        if (satelliteList.size() < 3) {
            throw new NotFoundException(NOT_FOUND_INFO_ERROR);
        }
        try {
            satelliteDtoList = satelliteList.stream()
                    .map((element) -> mapper.map(element, SatelliteDto.class))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new InternalServerErrorException(INTERNAL_SERVER_ERROR);
        }
        return getTopSecret(satelliteDtoList);
    }
}