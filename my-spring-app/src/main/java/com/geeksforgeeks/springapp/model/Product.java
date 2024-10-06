package com.geeksforgeeks.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@With
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    private int productId;

    private String name;
    private double price;
    private String brandName;

    @OneToMany
    private List<ProductRating> productRatingList;

}
