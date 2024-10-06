package com.geeksforgeeks.springapp.mapper;

import com.geeksforgeeks.springapp.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Product.builder ()
                .productId ( rs.getInt ( "productid" ) )
                .name ( rs.getString ( "name" ) )
                .price ( rs.getDouble ( "price" ) )
                .build ();
    }

}
