package com.geeksforgeeks.servicetwo.service_two.clients;

import com.geeksforgeeks.servicetwo.service_two.dao.ServiceOneResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-one", url = "http://localhost:7070")
public interface ServiceOneClient {

    @GetMapping("/first_name")
    ServiceOneResponse getFirstName();

}

/*
Load Balancing Algorithms:
1. Round Robin
2. Weighted Round Robin
3. Least Connections
4. Weight Least Connections
5. Least Response Time
6. IP Hash
7. Random Choice
8. Consistent Hashing
9. Least Bandwidth
10.Resource-Based Load Balancing
 */