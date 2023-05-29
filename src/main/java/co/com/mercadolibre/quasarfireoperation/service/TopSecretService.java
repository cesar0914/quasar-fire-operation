package co.com.mercadolibre.quasarfireoperation.service;

import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import co.com.mercadolibre.quasarfireoperation.model.dto.response.TopSecretResponse;

import java.util.List;

public interface TopSecretService {
    TopSecretResponse getTopSecret(List<SatelliteDto> satellites);
}
