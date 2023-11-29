package com.bulutmd.egitim.basketservice.service;

import com.bulutmd.egitim.basketservice.model.Basket;
import com.bulutmd.egitim.basketservice.model.dto.BasketItemRequest;
import com.bulutmd.egitim.basketservice.model.dto.BasketResponse;
import com.bulutmd.egitim.basketservice.model.dto.ProductDto;
import com.bulutmd.egitim.basketservice.repository.BasketRepository;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {

    @Autowired
    BasketRepository repository;

    private Gson gson = new Gson();
    private String productServiceUrl = "http://localhost:9000/product-service/";

    //

    public BasketResponse getBasketOfUser(String username) {
        Basket basket = repository.findByUsername(username);
        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setUsername(basket.getUsername());
        basketResponse.setId(basket.getId());

        try {
            for (Long productId : basket.getProducts()) {
                String json = Request.Get(productServiceUrl + productId).execute().returnContent().asString();
                ProductDto productDto = gson.fromJson(json, ProductDto.class);
                basketResponse.getProducts().add(productDto);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return basketResponse;
    }

    public Basket addToBasket(BasketItemRequest request) {
        Basket basket = repository.findByUsername(request.getUsername());

        if (basket == null) {
            basket = new Basket();
            basket.setUsername(request.getUsername());
        }

        List<Long> products = basket.getProducts();
        if (products == null) {
            basket.setProducts(new ArrayList<>());
        }

        if (!basket.getProducts().contains(request.getProductId())) {
            basket.getProducts().add(request.getProductId());
        }
        return repository.save(basket);
    }

    public Basket removeFromBasket(BasketItemRequest request) {
        Basket basket = repository.findByUsername(request.getUsername());
        basket.getProducts().remove(request.getProductId());
        return repository.save(basket);
    }
}
