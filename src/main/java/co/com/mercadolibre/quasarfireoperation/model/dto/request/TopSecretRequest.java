package co.com.mercadolibre.quasarfireoperation.model.dto.request;

import co.com.mercadolibre.quasarfireoperation.model.dto.SatelliteDto;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class TopSecretRequest {
    @Valid
    private List<SatelliteDto> satellites;
}
