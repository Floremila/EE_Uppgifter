package se.floremila.ee_uppgifter.lektion2.duck.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import se.floremila.ee_uppgifter.lektion2.duck.model.Duck;
import se.floremila.ee_uppgifter.lektion2.duck.service.DuckService;

@RestController
public class DuckController {

    private final DuckService duckService;

    public DuckController(DuckService duckService) {
        this.duckService = duckService;
    }


    @GetMapping("/duck")
    public Mono<ResponseEntity<Duck>> getRandomDuck() {
        return duckService
                .getRandomDuck()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}

