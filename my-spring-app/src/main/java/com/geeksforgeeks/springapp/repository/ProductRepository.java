package com.geeksforgeeks.springapp.repository;

import com.geeksforgeeks.springapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
