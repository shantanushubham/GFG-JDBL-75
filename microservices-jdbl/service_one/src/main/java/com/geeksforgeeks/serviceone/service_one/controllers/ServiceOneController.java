package com.geeksforgeeks.serviceone.service_one.controllers;

import com.geeksforgeeks.serviceone.service_one.dao.ResponseDao;
import com.geeksforgeeks.serviceone.service_one.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOneController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public ServiceOneController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/first_name")
    public ResponseEntity<ResponseDao> getFirstName() {
        return ResponseEntity.ok(new ResponseDao("Shantanu"));
    }

    @PostMapping("/kafka-send")
    public String sendMessage(@RequestParam String message) {
        this.kafkaProducer.sendMessage(message);
        return "Message sent: " + message;
    }

}


/*
Services:
1. Service Discovery
2. API Gateway
3. Config Management
4. Circuit Breaker
5. Load Balancing
 */
