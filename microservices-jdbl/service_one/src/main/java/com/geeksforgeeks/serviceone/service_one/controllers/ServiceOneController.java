package com.geeksforgeeks.serviceone.service_one.controllers;

import com.geeksforgeeks.serviceone.service_one.dao.ResponseDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOneController {

    @GetMapping("/first_name")
    public ResponseEntity<ResponseDao> getFirstName() {
        return ResponseEntity.ok(new ResponseDao("Shantanu"));
    }

}
