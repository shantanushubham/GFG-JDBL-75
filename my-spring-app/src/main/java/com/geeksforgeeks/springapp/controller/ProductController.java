package com.geeksforgeeks.springapp.controller;

import com.geeksforgeeks.springapp.model.Product;
import com.geeksforgeeks.springapp.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        log.info ( "Fetching the list of products" );
        List<Product> productList = new ArrayList<> ();
        try (BufferedReader br = new BufferedReader ( new FileReader ( "src/productlist.txt" ) )) {
            String line = br.readLine ();
            while (line != null) {
                String[] info = line.split ( "\\|" );
                Product product = Product.builder ()
                        .productId ( Integer.parseInt ( info[0] ) )
                        .name ( info[1] )
                        .price ( Double.parseDouble ( info[2] ) )
                        .build ();
                productList.add ( product );
                line = br.readLine ();
            }
            log.info ( "Fetched {} products", productList.size () );
            return productList;
        } catch (IOException exception) {
            log.error ( "An exception occurred: {}", exception.getMessage () );
            return productList;
        }
    }

    public void addNewProduct(Product product) {
        List<Product> productList = this.getAllProducts ();
        product.setProductId ( productList.get ( productList.size () - 1 ).getProductId () + 1 );
        productList.add ( product );
        try (BufferedWriter bw = new BufferedWriter ( new FileWriter ( "src/productlist.txt" ) )) {
            for (Product p : productList) {
                bw.write ( p.getProductId () + "|" + p.getName () + "|" + p.getPrice () );
                bw.newLine ();
            }
        } catch (IOException e) {
            throw new RuntimeException ( e );
        }
    }

    @GetMapping("/get-products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = this.productRepository.findAll ();
        return new ResponseEntity<> ( productList, HttpStatus.OK );
    }

    @PostMapping("/add-product")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<Product> addNewProduct1(@RequestBody Product product) {
        Product savedProduct = this.productRepository.save ( product );
        log.info ( "Product Added. Returned value: {}", savedProduct );
        return new ResponseEntity<> ( savedProduct, HttpStatus.CREATED );
    }

}
