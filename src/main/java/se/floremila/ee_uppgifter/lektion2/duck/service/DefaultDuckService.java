package se.floremila.ee_uppgifter.lektion2.duck.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
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
        return duckWebClient
                .get()
                .retrieve()
                .onStatus(HttpStatusCode::isError, resp ->
                        resp.bodyToMono(String.class)
                                .defaultIfEmpty("error")
                                .flatMap(body -> Mono.error(new RuntimeException("Duck API error: " + body)))
                )
                .bodyToMono(Duck.class);
    }
}


