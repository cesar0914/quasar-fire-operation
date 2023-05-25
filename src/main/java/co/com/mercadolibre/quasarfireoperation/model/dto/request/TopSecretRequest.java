package co.com.mercadolibre.quasarfireoperation.model.dto.request;

import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import lombok.Data;

import java.util.List;

@Data
public class TopSecretRequest {
    private List<SatelliteDto> satellites;
}
