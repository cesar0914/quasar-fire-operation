package co.com.mercadolibre.quasarfireoperation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiException> handlerRequestException(NotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException = ApiException.builder().httpStatus(notFound).message(e.getMessage()).code(notFound.value()).build();
        return new ResponseEntity<>(apiException, notFound);
    }
}
