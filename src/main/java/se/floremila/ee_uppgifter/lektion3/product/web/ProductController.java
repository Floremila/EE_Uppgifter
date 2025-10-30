package se.floremila.ee_uppgifter.lektion3.product.web;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.floremila.ee_uppgifter.lektion3.product.model.Product;
import se.floremila.ee_uppgifter.lektion3.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product input) {
        log.info("HTTP POST /products");
        Product created = service.createProduct(input);
        log.info("HTTP 201 /products id={}", created.getId());
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/search")
    public ResponseEntity<Product> findByName(@RequestParam String name) {
        log.info("HTTP GET /products/search name={}", name);
        Product p = service.findByName(name);
        log.info("HTTP 200 /products/search id={}", p.getId());
        return ResponseEntity.ok(p);
    }
}

