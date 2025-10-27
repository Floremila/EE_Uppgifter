package se.floremila.ee_uppgifter.lektion2.duck.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import se.floremila.ee_uppgifter.lektion2.duck.model.Duck;

@Service
public class DefaultDuckService implements DuckService {

    private final WebClient duckWebClient;

    public DefaultDuckService(@Qualifier("duckWebClient") WebClient duckWebClient) {
        this.duckWebClient = duckWebClient;
    }

    @Override
    public Mono<Duck> getRandomDuck() {
        return Mono.empty();
    }
}

