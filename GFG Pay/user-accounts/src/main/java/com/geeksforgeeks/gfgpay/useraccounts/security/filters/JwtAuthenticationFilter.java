//package com.geeksforgeeks.gfgpay.useraccounts.security.filters;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.geeksforgeeks.gfgpay.useraccounts.dto.AuthDto;
//import com.geeksforgeeks.gfgpay.useraccounts.util.JwtUtil;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//
//    @Autowired
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            AuthDto authDto = new ObjectMapper().readValue(request.getInputStream(), AuthDto.class);
//            UsernamePasswordAuthenticationToken authenticationToken =
//                    new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
//            return authenticationManager.authenticate(authenticationToken);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(
//            HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
//        User user = (User) authResult.getPrincipal();
//        String jwtToken = this.jwtUtil.generateToken(user);
//        response.setContentType("application/json");
//        response.getWriter().write("{\"token\": \"" + jwtToken + "\"}");
//    }
//}
