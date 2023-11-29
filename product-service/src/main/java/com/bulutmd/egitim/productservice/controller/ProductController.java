package com.bulutmd.egitim.productservice.controller;

import com.bulutmd.egitim.productservice.model.Product;
import com.bulutmd.egitim.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> list() {
        return service.listAll();
    }

    @GetMapping("/{productId}")
    public Product list(@PathVariable long productId) {
        return service.find(productId);
    }

    @PostMapping
    public Product saveOrUpdate(@RequestBody Product entity) {
        return service.save(entity);
    }

}
