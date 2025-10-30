package se.floremila.ee_uppgifter.lektion3.product.web;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.floremila.ee_uppgifter.lektion3.product.model.Product;
import se.floremila.ee_uppgifter.lektion3.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product input) {
        Product created = service.createProduct(input);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/search")
    public ResponseEntity<Product> findByName(@RequestParam String name) {
        Product p = service.findByName(name);
        return ResponseEntity.ok(p);
    }
}

