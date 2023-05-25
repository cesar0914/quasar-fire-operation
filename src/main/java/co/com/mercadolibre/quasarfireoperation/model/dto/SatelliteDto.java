package co.com.mercadolibre.quasarfireoperation.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class SatelliteDto {
    private String name;
    private double distance;
    private List<String> message;
}
