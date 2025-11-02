package se.floremila.ee_uppgifter.lektion4.message.service;

import reactor.core.publisher.Mono;
import se.floremila.ee_uppgifter.lektion4.message.model.Message;

public interface MessageService {
    Mono<Message> createMessage(String text);
    Mono<Message> getById(Long id);
}
