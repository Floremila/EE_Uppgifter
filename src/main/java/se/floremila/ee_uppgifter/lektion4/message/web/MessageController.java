package se.floremila.ee_uppgifter.lektion4.message.web;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
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
                .map(saved -> ResponseEntity.created(URI.create("/messages/" + saved.id())).body(saved));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Message>> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<Message> getAll() {
        return service.getAll();
    }

    @GetMapping("/pinned")
    public Flux<Message> getPinned() {
        return service.getPinned();
    }
}
