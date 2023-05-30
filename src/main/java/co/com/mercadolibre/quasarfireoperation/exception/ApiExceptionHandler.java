package co.com.mercadolibre.quasarfireoperation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiException> handlerRequestException(NotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException = ApiException.builder().httpStatus(notFound).message(e.getMessage()).code(notFound.value()).build();
        return new ResponseEntity<>(apiException, notFound);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ApiException> handlerRequestException(InternalServerErrorException e) {
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiException apiException = ApiException.builder().httpStatus(internalServerError).message(e.getMessage()).code(internalServerError.value()).build();
        return new ResponseEntity<>(apiException, internalServerError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> handlerRequestException(MethodArgumentNotValidException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        ApiException apiException = ApiException.builder().httpStatus(badRequest).message(message).code(badRequest.value()).build();
        return new ResponseEntity<>(apiException, badRequest);
    }
}
