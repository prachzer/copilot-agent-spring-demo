package com.example.demo;

public record Product(
        Long id,
        String name,
        String category,
        double price
) {
}
