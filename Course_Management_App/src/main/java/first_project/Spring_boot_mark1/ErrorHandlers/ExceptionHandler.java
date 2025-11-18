package first_project.Spring_boot_mark1.ErrorHandlers;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> IOexceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RelevantException.class)
    public ResponseEntity<?> RelevantException(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> ValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        HashMap<String,String> map = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error -> map.put(error.getField(),error.getDefaultMessage()));
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> DataConstraintViolation(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException){
        HashMap<String,String> map = new HashMap<>();
        sqlIntegrityConstraintViolationException.getLocalizedMessage();
        map.put("Error",sqlIntegrityConstraintViolationException.getLocalizedMessage());
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }
}
