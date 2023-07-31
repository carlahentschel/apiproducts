package com.apiprodutos.produtos.repositories;

import com.apiprodutos.produtos.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
   boolean existsByName(String name);
}
