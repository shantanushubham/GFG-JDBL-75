package com.geeksforgeeks.library.elib.controller;

import com.geeksforgeeks.library.elib.dto.AuthDto;
import com.geeksforgeeks.library.elib.entity.Member;
import com.geeksforgeeks.library.elib.exceptions.IncorrectCredentialsException;
import com.geeksforgeeks.library.elib.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    private ResponseEntity<Member> login(@RequestBody AuthDto authDto) {
       try {
           Member member = this.authenticationService.login(authDto);
           return new ResponseEntity<>(member, HttpStatus.OK);
       } catch (UsernameNotFoundException | IncorrectCredentialsException exception) {
           return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
       }
    }

    @PostMapping("/signup")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member addedMember = this.authenticationService.signUp(member);
        return new ResponseEntity<>(addedMember, HttpStatus.CREATED);
    }
}
