package se.floremila.ee_uppgifter.lektion2.duck.service;
import reactor.core.publisher.Mono;
import se.floremila.ee_uppgifter.lektion2.duck.model.Duck;

public interface DuckService {
    Mono<Duck> getRandomDuck();
}