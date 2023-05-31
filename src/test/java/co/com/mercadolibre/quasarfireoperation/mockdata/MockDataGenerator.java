package co.com.mercadolibre.quasarfireoperation.mockdata;

import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import co.com.mercadolibre.quasarfireoperation.model.dto.request.TopSecretRequest;
import co.com.mercadolibre.quasarfireoperation.model.dto.response.TopSecretResponse;
import co.com.mercadolibre.quasarfireoperation.model.entity.Satellite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MockDataGenerator {

    public static SatelliteDto generateSatelliteDtoMockData() {
        SatelliteDto satelliteDto = new SatelliteDto();
        satelliteDto.setName("kenobi");
        satelliteDto.setDistance(100.0);
        satelliteDto.setMessage(new String[]{"este", "", "", "mensaje", ""});
        return satelliteDto;
    }

    public static TopSecretRequest generateTopSecretRequestMockData() {
        TopSecretRequest request = new TopSecretRequest();
        List<SatelliteDto> satellites = new ArrayList<>();

        SatelliteDto kenobiSatellite = new SatelliteDto();
        kenobiSatellite.setName("kenobi");
        kenobiSatellite.setDistance(100.0);
        kenobiSatellite.setMessage(new String[]{"este", "", "", "mensaje", ""});
        satellites.add(kenobiSatellite);

        SatelliteDto skywalkerSatellite = new SatelliteDto();
        skywalkerSatellite.setName("skywalker");
        skywalkerSatellite.setDistance(115.5);
        skywalkerSatellite.setMessage(new String[]{"", "es", "", "", "secreto"});
        satellites.add(skywalkerSatellite);

        SatelliteDto satoSatellite = new SatelliteDto();
        satoSatellite.setName("sato");
        satoSatellite.setDistance(142.7);
        satoSatellite.setMessage(new String[]{"este", "", "un", "", ""});
        satellites.add(satoSatellite);

        request.setSatellites(satellites);
        return request;
    }
    public static TopSecretResponse generateTopSecretResponseMockData() {
        Point position = new Point(100, 200);
        String message = "Este es un mensaje secreto";

        return TopSecretResponse.builder()
                .position(position)
                .message(message)
                .build();
    }

    public static List<Satellite> getSatellitesMockData() {
        List<Satellite> satellites = new ArrayList<>();

        Satellite satellite1 = new Satellite();
        satellite1.setId("1");
        satellite1.setName("kenobi");
        satellite1.setDistance(100.0);
        satellite1.setMessage(new String[]{"este", "", "", "mensaje", ""});

        Satellite satellite2 = new Satellite();
        satellite2.setId("2");
        satellite2.setName("skywalker");
        satellite2.setDistance(115.5);
        satellite2.setMessage(new String[]{"", "es", "", "", "secreto"});

        Satellite satellite3 = new Satellite();
        satellite3.setId("3");
        satellite3.setName("sato");
        satellite3.setDistance(142.7);
        satellite3.setMessage(new String[]{"este", "", "un", "", ""});

        satellites.add(satellite1);
        satellites.add(satellite2);
        satellites.add(satellite3);

        return satellites;
    }
}