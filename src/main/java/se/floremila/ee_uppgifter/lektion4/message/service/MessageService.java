package se.floremila.ee_uppgifter.lektion4.message.service;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import se.floremila.ee_uppgifter.lektion4.message.model.Message;

import java.time.LocalDateTime;

public interface MessageService {
    Mono<Message> createMessage(String text);
    Mono<Message> getById(Long id);
    Flux<Message> getAll();
}
