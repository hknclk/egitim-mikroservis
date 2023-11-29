package com.bulutmd.egitim.productservice.repository;


import com.bulutmd.egitim.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
