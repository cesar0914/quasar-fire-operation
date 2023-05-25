package co.com.mercadolibre.quasarfireoperation.service;

import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;

import java.awt.*;
import java.util.List;

public interface TopSecretService {
    String getMessage(List<SatelliteDto> satelliteDtoList);
    Point GetLocation(List<SatelliteDto> satelliteDtoList);
}
