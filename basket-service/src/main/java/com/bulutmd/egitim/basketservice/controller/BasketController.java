package com.bulutmd.egitim.basketservice.controller;

import com.bulutmd.egitim.basketservice.model.Basket;
import com.bulutmd.egitim.basketservice.model.dto.BasketItemRequest;
import com.bulutmd.egitim.basketservice.model.dto.BasketResponse;
import com.bulutmd.egitim.basketservice.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasketController {

    @Autowired
    private BasketService service;

    @GetMapping
    public BasketResponse getBasket(@RequestParam String username) {
        return service.getBasketOfUser(username);
    }

    @PostMapping("/add")
    public Basket addToBasket(@RequestBody BasketItemRequest request) {
        return service.addToBasket(request);
    }

    @PostMapping("/remove")
    public Basket removeFromBasket(@RequestBody BasketItemRequest request) {
        return service.removeFromBasket(request);
    }

}
