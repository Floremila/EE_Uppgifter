package se.floremila.ee_uppgifter.lektion4.message.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class MessageCreateRequest {
    @NotBlank(message = "message must not be blank")
    private String message;


    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    public MessageCreateRequest() { }
    public MessageCreateRequest(String message) { this.message = message; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

