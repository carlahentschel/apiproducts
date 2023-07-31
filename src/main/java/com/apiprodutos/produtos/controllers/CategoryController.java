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

@PostMapping
    public ResponseEntity createCategory(@RequestBody @Valid CreateCategory newCategory){
    if(repository.existsByName(newCategory.name())){
        return ResponseEntity.badRequest().body(new ResponseError("Essa categoria já existe"));
    }
    var category = new Category(newCategory);

    category = repository.save(category);

    return ResponseEntity.ok().body(category);
}

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable @Valid UUID id){
        if(!repository.existsById(id)){
            return ResponseEntity.badRequest().body(new ResponseError("Essa categoria não existe"));
        }
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

@GetMapping
    public ResponseEntity getAll(){return ResponseEntity.ok().body(repository.findAll());}

}
