package es.tuespiral.soterocars.apierror;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	/*@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFoundException(ProductNotFoundException ex) {
		ApiErrorResponse response = new ApiErrorResponse("PR-001", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(ProductException.class)
    public ResponseEntity<ApiErrorResponse> ProductException(ProductException ex) {
        ApiErrorResponse response = new ApiErrorResponse("PR-002", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }*/
}
