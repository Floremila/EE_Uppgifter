package se.floremila.ee_uppgifter.lektion3.product.service;

import se.floremila.ee_uppgifter.lektion3.product.model.Product;

public interface ProductService {
    Product createProduct(Product p);

    Product findByName(String name);
}
