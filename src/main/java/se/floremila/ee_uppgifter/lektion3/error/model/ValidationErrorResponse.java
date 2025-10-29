package se.floremila.ee_uppgifter.lektion3.error.model;

import java.time.Instant;
import java.util.List;

public class ValidationErrorResponse extends ErrorResponse {

    public static class FieldErrorItem {
        private String field;
        private String message;

        public FieldErrorItem() { }
        public FieldErrorItem(String field, String message) {
            this.field = field;
            this.message = message;
        }
        public String getField() { return field; }
        public void setField(String field) { this.field = field; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    private List<FieldErrorItem> errors;

    public ValidationErrorResponse() { }

    public ValidationErrorResponse(Instant ts, int status, String error, String msg, String path, List<FieldErrorItem> errors) {
        super(ts, status, error, msg, path);
        this.errors = errors;
    }

    public List<FieldErrorItem> getErrors() { return errors; }
    public void setErrors(List<FieldErrorItem> errors) { this.errors = errors; }
}
