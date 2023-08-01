package com.apiprodutos.produtos.controllers;

import com.apiprodutos.produtos.dtos.CreateBrand;
import com.apiprodutos.produtos.dtos.ResponseError;
import com.apiprodutos.produtos.models.Brand;
import com.apiprodutos.produtos.repositories.BrandRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandRepository repository;


    @GetMapping
    public ResponseEntity getBrand() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity createBrand(@RequestBody @Valid CreateBrand newBrand) {
        if (repository.existsByNameIgnoreCase(newBrand.name())) {
            return ResponseEntity.badRequest().body(new ResponseError("Essa marca já existe"));
        }
        var brand = new Brand(newBrand);
        brand = repository.save(brand);

        return ResponseEntity.ok().body(brand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBrand(@PathVariable @Valid UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.badRequest().body(new ResponseError("Essa marca não existe"));
        }
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
