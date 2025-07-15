package com.lucasleao.clienteservice.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 📌 Esta classe trata exceções globalmente para todos os controllers.
 */
@ControllerAdvice // 🔹 Aponta para o Spring aplicar esta classe a todos os @Controller/@RestController
public class GlobalExceptionHandler {

    /**
     * 🎯 Trata erros de validação automática (ex: @NotBlank, @Email).
     *
     * @param ex exceção gerada quando uma validação falha
     * @return mapa de campo → mensagem de erro
     */
    @ExceptionHandler(MethodArgumentNotValidException.class) // 🔹 Captura validações do Bean Validation
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        // 🔍 Percorre os erros e coleta o nome do campo + mensagem
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // 🔴 400 Bad Request
    }
}
