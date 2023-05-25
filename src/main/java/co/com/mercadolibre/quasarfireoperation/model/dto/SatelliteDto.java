package co.com.mercadolibre.quasarfireoperation.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class SatelliteDto {
    @Schema(example = "kenobi")
    private String name;
    @Schema(example = "100.0")
    private double distance;
    @Schema(example = "[\"este\",\"\",\"\",\"mensaje\",\"\"]")
    private List<String> message;
}
