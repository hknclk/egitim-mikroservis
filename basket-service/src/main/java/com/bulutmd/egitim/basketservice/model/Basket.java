package com.bulutmd.egitim.basketservice.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Basket {

    @Id
    @GeneratedValue
    private long id;

    private String username;

    @ElementCollection
    private List<Long> products;

}
