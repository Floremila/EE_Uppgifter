package se.floremila.ee_uppgifter.lektion2.duck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DuckWebClientConfig {


    @Bean("duckWebClient")
    public WebClient duckWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("https://random-d.uk/api/v2/random")
                .build();
    }
}


