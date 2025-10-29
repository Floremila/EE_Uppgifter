package se.floremila.ee_uppgifter.lektion3.error.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
