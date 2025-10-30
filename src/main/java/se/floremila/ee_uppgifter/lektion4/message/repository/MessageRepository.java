package se.floremila.ee_uppgifter.lektion4.message.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import se.floremila.ee_uppgifter.lektion4.message.model.Message;

@Repository
public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {

}
