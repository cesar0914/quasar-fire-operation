package co.com.mercadolibre.quasarfireoperation.model.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.awt.*;

@Builder
@Getter
public class TopSecretResponse {
    private Point position;
    private String message;
}
