package com.apiprodutos.produtos.controllers;

import com.apiprodutos.produtos.dtos.CreateCategory;
import com.apiprodutos.produtos.dtos.ResponseError;
import com.apiprodutos.produtos.models.Category;
import com.apiprodutos.produtos.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/categories")

public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity createCategory(@RequestBody @Valid CreateCategory newCategory) {
        if (repository.existsByNameIgnoreCase(newCategory.name())) {
            return ResponseEntity.badRequest().body(new ResponseError("Essa categoria já existe"));
        }

        var category = repository.save(new Category(newCategory));

        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable @Valid UUID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.badRequest().body(new ResponseError("Essa categoria não existe"));
        }
        
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

