package com.apiprodutos.produtos.models;

import com.apiprodutos.produtos.dtos.CreateProduct;
import com.apiprodutos.produtos.dtos.EditProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private double price;
    private int stock;
    @OneToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;
    private int barcode;
    @OneToMany
    private List<Category> categories;

    public Product(CreateProduct newProduct) {
        name = newProduct.name();
        price = newProduct.price();
        stock = newProduct.stock();
        brand = newProduct.brand();
        barcode = newProduct.barcode();
        categories = newProduct.categories();
        if(categories == null) categories = new ArrayList<>();
    }


    public void update(EditProduct p){
        name =  p.name();
        price = p.price();
        stock = p.stock();
        categories = p.categories();
    }
}
