package se.floremila.ee_uppgifter.lektion4.message.web;

import jakarta.validation.constraints.NotBlank;

public class MessageCreateRequest {
    @NotBlank(message = "message must not be blank")
    private String message;

    public MessageCreateRequest() { }
    public MessageCreateRequest(String message) { this.message = message; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

