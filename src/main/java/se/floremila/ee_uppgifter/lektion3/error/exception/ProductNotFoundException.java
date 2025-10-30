package se.floremila.ee_uppgifter.lektion3.error.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super("Product with name '" + name + "' was not found");
    }
}
