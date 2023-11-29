package com.bulutmd.egitim.basketservice.repository;


import com.bulutmd.egitim.basketservice.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findByUsername(String username);


}
