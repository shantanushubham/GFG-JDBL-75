package com.geeksforgeeks.servicetwo.service_two.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "geeks-for-geeks-topic", groupId = "service-two-group")
    public void consume(String message) {
        System.out.printf("Received message in Service Two: " + message);
    }
}
