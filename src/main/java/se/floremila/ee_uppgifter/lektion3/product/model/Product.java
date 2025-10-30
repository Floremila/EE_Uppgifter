package se.floremila.ee_uppgifter.lektion3.product.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class Product {
    private long id;

    @NotBlank(message = "name must not be blank")
    @Size(min = 2, message = "name must be at least 2 characters")
    private String name;

    @DecimalMin(value = "0.01", inclusive = true, message = "price must be at least 0.01")
    private BigDecimal price;

    public Product() { }

    public Product(long id, String name, BigDecimal price) {
        this.id = id; this.name = name; this.price = price;
    }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
