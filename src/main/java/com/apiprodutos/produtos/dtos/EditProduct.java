package com.apiprodutos.produtos.dtos;

import com.apiprodutos.produtos.models.Brand;
import com.apiprodutos.produtos.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record EditProduct(
        @NotBlank
        String name,

        @NotNull
        @Positive
        double price,

        @NotNull
        int stock,

        List<Category>categories


) {
}
