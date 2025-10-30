package se.floremila.ee_uppgifter.lektion3.product.service;

import org.springframework.stereotype.Service;
import se.floremila.ee_uppgifter.lektion3.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InMemoryProductService implements ProductService {
    private final List<Product> store = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public Product createProduct(Product p) {
        p.setId(sequence.getAndIncrement());
        store.add(p);
        return p;
    }
}

