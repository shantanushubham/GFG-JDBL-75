package com.geeksforgeeks.gfgpay.useraccounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
//import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
public class AuthResponse {
//    private UserDetails user;
    private String token;
}
