package se.floremila.ee_uppgifter.lektion4.message.error.exception;

import se.floremila.ee_uppgifter.lektion3.error.exception.ResourceNotFoundException;

public class MessageNotFoundException extends ResourceNotFoundException {
    public MessageNotFoundException(Long id) {
        super("Message with id '" + id + "' was not found");
    }
}
