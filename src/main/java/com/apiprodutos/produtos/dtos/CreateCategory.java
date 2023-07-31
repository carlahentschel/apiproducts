package com.apiprodutos.produtos.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateCategory(

        @NotBlank
        String name) {
}
