package com.apiprodutos.produtos.dtos;

import com.apiprodutos.produtos.models.Brand;
import com.apiprodutos.produtos.models.Category;
import com.apiprodutos.produtos.models.Product;

import java.util.List;
import java.util.UUID;

public record OutputProduct(
        UUID id,
        String name,

        String brand,

        double price,

        int stock,

        List<String> categories
) {
    public OutputProduct(Product p){

        this(p.getId(),
                p.getName(),
                p.getBrand().getName(),
                p.getPrice(), p.getStock(),
                p.getCategories().stream().map(Category::getName).toList());

    }
}
