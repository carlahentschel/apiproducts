package com.apiprodutos.produtos.repositories;

import com.apiprodutos.produtos.models.Brand;
import com.apiprodutos.produtos.models.Category;
import com.apiprodutos.produtos.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    boolean existsByBarcode(int barcode);

    boolean existsByNameAndBrand(String name, Brand brand);
}
