package co.com.mercadolibre.quasarfireoperation.service.impl;

import co.com.mercadolibre.quasarfireoperation.exception.NotFoundException;
import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import co.com.mercadolibre.quasarfireoperation.service.TopSecretService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

import static co.com.mercadolibre.quasarfireoperation.utils.TopSecretConstant.NOT_FOUND_POSITION_ERROR;

@Service
@Log4j2
public class TopSecretServiceImpl implements TopSecretService {
    @Override
    public String getMessage(List<SatelliteDto> satelliteDtoList) {
        return null;
    }

    @Override
    public Point GetLocation(List<SatelliteDto> satelliteDtoList) {
        log.info("Getting location");
        throw new NotFoundException(NOT_FOUND_POSITION_ERROR);
    }
}
