package com.geeksforgeeks.gfgpay.useraccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.geeksforgeeks.gfgpay.transactions.repository",
        "com.geeksforgeeks.gfgpay.useraccounts.repository"})
@EntityScan(basePackages = "com.geeksforgeeks.gfgpay.common.models")
@ComponentScan(basePackages = {
        "com.geeksforgeeks.gfgpay.useraccounts",
        "com.geeksforgeeks.gfgpay.common",
        "com.geeksforgeeks.gfgpay.transactions"
})
public class UserAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAccountsApplication.class, args);
    }
}
