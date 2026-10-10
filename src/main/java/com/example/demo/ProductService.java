
package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product(1L, "MacBook", "electronics", 45000),
            new Product(2L, "Mouse", "electronics", 800),
            new Product(3L, "Desk", "furniture", 3500),
            new Product(4L, "Keyboard", "electronics", 2200)
    );

    public List<Product> findProducts(String category, Double maxPrice) {
        return products.stream()
                .filter(product -> category == null
                        || product.category().equalsIgnoreCase(category))
                // DEMO BUG: maxPrice is intentionally ignored
                .toList();
    }
}
