package co.com.mercadolibre.quasarfireoperation.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class SatelliteDto {
    @Schema(example = "kenobi")
    private String name;
    @Schema(example = "100.0")
    @Positive(message = "El valor de la distancia debe ser positivo.")
    private double distance;
    @Schema(example = "[\"este\",\"\",\"\",\"mensaje\",\"\"]")
    private String[] message;
}
