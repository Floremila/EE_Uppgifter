package se.floremila.ee_uppgifter.lektion3.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.floremila.ee_uppgifter.lektion3.error.exception.ProductNotFoundException;
import se.floremila.ee_uppgifter.lektion3.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InMemoryProductService implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(InMemoryProductService.class);

    private final List<Product> store = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public Product createProduct(Product p) {
        long id = sequence.getAndIncrement();
        p.setId(id);
        store.add(p);
        log.info("Product created: id={}, name={}, price={}", id, p.getName(), p.getPrice());
        log.debug("Store size after create: {}", store.size());
        return p;
    }

    @Override
    public Product findByName(String name) {
        log.info("Searching product by name={}", name);
        return store.stream()
                .filter(prod -> prod.getName() != null && prod.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> {
                    log.warn("Product not found for name={}", name);
                    return new ProductNotFoundException(name);
                });
    }
}
