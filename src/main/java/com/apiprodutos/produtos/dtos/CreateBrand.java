package com.apiprodutos.produtos.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateBrand(
        @NotBlank
        String name
) {


}
