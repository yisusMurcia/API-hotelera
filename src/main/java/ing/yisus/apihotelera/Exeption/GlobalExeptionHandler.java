package ing.yisus.apihotelera.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(ResourceNotFoundExeption.class)
    public ResponseEntity<String> handleNotFoundExeption(ResourceNotFoundExeption exeption, WebRequest webRequest){
        return  new ResponseEntity<>(exeption.getMessage(), HttpStatus.NOT_FOUND);
    }

}
