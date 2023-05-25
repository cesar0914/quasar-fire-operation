package co.com.mercadolibre.quasarfireoperation.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ApiException {
    private int code;
    private HttpStatus httpStatus;
    private String message;

}
