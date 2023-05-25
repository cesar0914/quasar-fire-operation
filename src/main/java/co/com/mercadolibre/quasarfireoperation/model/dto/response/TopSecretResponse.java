package co.com.mercadolibre.quasarfireoperation.model.dto.response;

import lombok.Builder;

import java.awt.*;

@Builder
public class TopSecretResponse {
    private Point position;
    private String message;
}
