package com.geeksforgeeks.servicetwo.service_two.service;

import com.geeksforgeeks.servicetwo.service_two.clients.ServiceOneClient;
import com.geeksforgeeks.servicetwo.service_two.dao.ServiceOneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTwoService {

    private final ServiceOneClient serviceOneClient;

    @Autowired
    public ServiceTwoService(ServiceOneClient serviceOneClient) {
        this.serviceOneClient = serviceOneClient;
    }

    public ServiceOneResponse fetchFirstName() {
        return this.serviceOneClient.getFirstName();
    }
}
