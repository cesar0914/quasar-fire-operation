package co.com.mercadolibre.quasarfireoperation.model.dto.response;

import co.com.mercadolibre.quasarfireoperation.model.dto.LocationDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TopSecretResponse {

    private LocationDto position;
    private String message;
}
