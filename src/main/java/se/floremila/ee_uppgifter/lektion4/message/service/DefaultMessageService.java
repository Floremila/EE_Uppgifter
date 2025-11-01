package se.floremila.ee_uppgifter.lektion4.message.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import se.floremila.ee_uppgifter.lektion4.message.model.Message;
import se.floremila.ee_uppgifter.lektion4.message.repository.MessageRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class DefaultMessageService implements MessageService {

    private static final Logger log = LoggerFactory.getLogger(DefaultMessageService.class);

    private final MessageRepository repository;

    public DefaultMessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Message> createMessage(String text) {
        String safe = (text == null || text.isBlank()) ? "(empty)" : text.trim();

        Message toSave = new Message(
                null,
                safe,
                LocalDateTime.now(ZoneOffset.UTC)
        );

        return repository
                .save(toSave)
                .doOnSuccess(saved -> log.info("Message created: id={}, createdAt={}", saved.id(), saved.createdAt()));
    }
}

