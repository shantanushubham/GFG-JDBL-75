package com.geeksforgeeks.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class ProductRating {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private double rating;

}

/*
One To One
Student Data | Student Marks
sid sname    | idx   sid smarks  subject
11  Shantanu | abc    11    95      Science
             | bcd    11    98      English
 */
