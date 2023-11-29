package com.bulutmd.egitim.basketservice.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BasketResponse {

    private long id;
    private String username;
    private List<ProductDto> products = new ArrayList<>();

}
