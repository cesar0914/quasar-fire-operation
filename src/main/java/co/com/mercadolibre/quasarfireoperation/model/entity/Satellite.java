package co.com.mercadolibre.quasarfireoperation.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "satellites")
public class Satellite {
    @Id
    private String id;
    private String name;
    private double distance;
    private String[] message;

}
