package com.apiprodutos.produtos.controllers;

import com.apiprodutos.produtos.dtos.CreateProduct;
import com.apiprodutos.produtos.dtos.EditProduct;
import com.apiprodutos.produtos.dtos.ResponseError;
import com.apiprodutos.produtos.models.Product;
import com.apiprodutos.produtos.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public ResponseEntity createProduct (@Valid @RequestBody CreateProduct newProduct){

        if(productRepository.existsByBarcode(newProduct.barcode())){
            return ResponseEntity.badRequest().body(new ResponseError("Código de barras já cadastrado!"));

        }

        if(productRepository.existsByNameAndBrand(newProduct.name(), newProduct.brand())){
            return ResponseEntity.badRequest().body(new ResponseError("Produto já cadastrado!"));

        }

        System.out.println(newProduct);

        var product = productRepository.save(new Product(newProduct));

        return ResponseEntity.ok().body(product);

    }

    @PutMapping("{idProduct}")
    @Transactional
    public  ResponseEntity editProduct (@Valid @RequestBody EditProduct newProduct, @PathVariable UUID idProduct){
        var product = productRepository.getReferenceById(idProduct);

        product.update(newProduct);

        return ResponseEntity.ok().build();
    }


}
