package br.com.fiap.moop.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    // captura exceções genéricas
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        ErroDTO erro = new ErroDTO(ex.getMessage(), null);
        model.addAttribute("erro", erro);
        return "error/erro";
    }

    // captura IllegalArgumentException (ex: validações manuais)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException ex, Model model) {
        ErroDTO erro = new ErroDTO(ex.getMessage(), null);
        model.addAttribute("erro", erro);
        return "error/erro";
    }

    // captura erros de validação do Bean Validation (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationException(MethodArgumentNotValidException ex, Model model) {
        // pega o primeiro erro de campo
        var fieldError = ex.getBindingResult().getFieldError();
        ErroDTO erro = new ErroDTO(
                fieldError != null ? fieldError.getDefaultMessage() : "Erro de validação",
                fieldError != null ? fieldError.getField() : null
        );
        model.addAttribute("erro", erro);
        return "error/erro";
    }
}
