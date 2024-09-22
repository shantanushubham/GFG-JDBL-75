package com.geeksforgeeks.springapp.model;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@With
@Builder
public class Product {

    private int productId;
    private String name;
    private double price;

}
