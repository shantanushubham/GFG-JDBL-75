package com.geeksforgeeks.gfgpay.useraccounts.controller;

import com.geeksforgeeks.gfgpay.common.models.User;
import com.geeksforgeeks.gfgpay.useraccounts.dto.AuthDto;
import com.geeksforgeeks.gfgpay.useraccounts.service.UserService;
//import com.geeksforgeeks.gfgpay.useraccounts.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

//    private final JwtUtil jwtUtil;
//    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Autowired
    public AuthController( UserService userService) {
//        this.jwtUtil = jwtUtil;
//        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody AuthDto authDto) {
//        Authentication authentication = this.authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword()));
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        String jwtToken = this.jwtUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthResponse(userDetails, jwtToken));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> addMember(@RequestBody User user) {
        User userToAdd = this.userService.addUser(user);
//        UserDetails userDetails = new User(userToAdd.getUsername(), userToAdd.getPassword(),
//                Collections.singletonList(new SimpleGrantedAuthority(
//                        user.getRole()
//                )));
//        String jwtToken = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(userToAdd);
    }
}
