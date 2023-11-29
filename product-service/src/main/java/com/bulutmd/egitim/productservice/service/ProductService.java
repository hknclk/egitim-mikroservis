package com.bulutmd.egitim.productservice.service;

import com.bulutmd.egitim.productservice.model.Product;
import com.bulutmd.egitim.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product find(long productId) {
        return repository.findById(productId).get();
    }

    public Product save(Product entity) {
        return repository.save(entity);
    }

}
