package se.floremila.ee_uppgifter.lektion4.message.web;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import se.floremila.ee_uppgifter.lektion4.message.model.Message;
import se.floremila.ee_uppgifter.lektion4.message.service.MessageService;

import java.net.URI;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }


    @PostMapping
    public Mono<ResponseEntity<Message>> create(@Valid @RequestBody MessageCreateRequest req) {
        return service.createMessage(req.getMessage())
                .map(saved -> ResponseEntity
                        .created(URI.create("/messages/" + saved.id())) // Location header
                        .body(saved));
    }
}
