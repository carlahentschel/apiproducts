package com.apiprodutos.produtos.dtos;

import com.apiprodutos.produtos.models.Brand;

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
}
