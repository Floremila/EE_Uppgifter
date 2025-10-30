package se.floremila.ee_uppgifter.lektion3.web.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import se.floremila.ee_uppgifter.lektion3.error.exception.BadRequestException;
import se.floremila.ee_uppgifter.lektion3.error.exception.ProductNotFoundException;
import se.floremila.ee_uppgifter.lektion3.error.exception.ResourceNotFoundException;
import se.floremila.ee_uppgifter.lektion3.error.model.ErrorResponse;
import se.floremila.ee_uppgifter.lektion3.error.model.ValidationErrorResponse;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException ex, HttpServletRequest req) {
        log.warn("Product not found at {}: {}", req.getRequestURI(), ex.getMessage());
        ErrorResponse body = new ErrorResponse(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                safeMessage(ex.getMessage(), "Requested product was not found."),
                req.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
        log.warn("Resource not found at {}: {}", req.getRequestURI(), ex.getMessage());
        ErrorResponse body = new ErrorResponse(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                safeMessage(ex.getMessage(), "Requested resource was not found."),
                req.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex, HttpServletRequest req) {
        log.warn("Bad request at {}: {}", req.getRequestURI(), ex.getMessage());
        ErrorResponse body = new ErrorResponse(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                safeMessage(ex.getMessage(), "Invalid request."),
                req.getRequestURI()
        );
        return ResponseEntity.badRequest().body(body);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        List<ValidationErrorResponse.FieldErrorItem> items = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::toItem)
                .collect(Collectors.toList());

        ValidationErrorResponse body = new ValidationErrorResponse(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "Validation failed.",
                req.getRequestURI(),
                items
        );
        log.debug("Validation errors at {}: {}", req.getRequestURI(), items.size());
        return ResponseEntity.badRequest().body(body);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAny(Exception ex, HttpServletRequest req) {
        // GDPR: no loguear datos personales del input
        log.error("Unhandled error at {}: {}", req.getRequestURI(), ex.toString());
        ErrorResponse body = new ErrorResponse(
                Instant.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Unexpected server error. Please try again later.",
                req.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    private ValidationErrorResponse.FieldErrorItem toItem(FieldError fe) {
        return new ValidationErrorResponse.FieldErrorItem(fe.getField(), fe.getDefaultMessage());
    }

    private String safeMessage(String preferred, String fallback) {
        if (preferred == null || preferred.isBlank()) return fallback;
        return preferred; //
    }
}
