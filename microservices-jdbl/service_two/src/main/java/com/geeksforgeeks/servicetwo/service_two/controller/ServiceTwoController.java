package com.geeksforgeeks.servicetwo.service_two.controller;

import com.geeksforgeeks.servicetwo.service_two.dao.ResponseDao;
import com.geeksforgeeks.servicetwo.service_two.service.ServiceTwoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ServiceTwoController {

    private final ServiceTwoService serviceTwoService;

    @Autowired
    public ServiceTwoController(ServiceTwoService serviceTwoService) {
        this.serviceTwoService = serviceTwoService;
    }

    @GetMapping("/last_name")
    public ResponseEntity<ResponseDao> getLastName() {
        String firstName = this.serviceTwoService.fetchFirstName().getFirstName();
        log.info("The firstName is {}", firstName);
        return ResponseEntity.ok(new ResponseDao("Shubham"));
    }
}
