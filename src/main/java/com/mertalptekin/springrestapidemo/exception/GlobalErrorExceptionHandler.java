package com.mertalptekin.springrestapidemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Burası API genelindeki tüm Hata durumlarını işleyen servisimiz

@RestControllerAdvice
public class GlobalErrorExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationErrors(MethodArgumentNotValidException ex) {

        // {"Name": ["Boş Geçilemez","Null Bırakılamaz"],"UnitPrice":["Negatif olamaz"]}
        Map<String, List<String>> errors = new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            // key ile hataları mapledik.
            List<String> errorList = fieldErrors.stream().filter(x-> x.getField().equals(error.getField())).map(FieldError::getDefaultMessage).collect(Collectors.toList());

            errors.put(error.getField(),errorList);

            System.out.println("hata" + error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
