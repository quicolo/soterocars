package es.tuespiral.soterocars.apierror;

import es.tuespiral.soterocars.reserva.ReservaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

	@ExceptionHandler(ReservaException.class)
    public ResponseEntity<ApiErrorResponse> ReservaException(ReservaException ex) {
        ApiErrorResponse response = new ApiErrorResponse("RES-001", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
