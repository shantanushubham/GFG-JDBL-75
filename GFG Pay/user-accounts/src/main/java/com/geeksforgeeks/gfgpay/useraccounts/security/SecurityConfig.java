//package com.geeksforgeeks.gfgpay.useraccounts.security;
//
//import com.geeksforgeeks.gfgpay.useraccounts.security.filters.JwtAuthenticationFilter;
//import com.geeksforgeeks.gfgpay.useraccounts.security.filters.JwtRequestFilter;
//import com.geeksforgeeks.gfgpay.useraccounts.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtRequestFilter jwtRequestFilter;
//    private final JwtUtil jwtUtil;
//
//    private  JwtAuthenticationFilter jwtAuthenticationFilter;
//
//
//    @Autowired
//    public SecurityConfig(JwtRequestFilter jwtRequestFilter, JwtUtil jwtUtil) {
//        this.jwtRequestFilter = jwtRequestFilter;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        this.jwtAuthenticationFilter = new JwtAuthenticationFilter(this.authenticationManager(
//                http.getSharedObject(AuthenticationConfiguration.class)), this.jwtUtil);
//        jwtAuthenticationFilter.setFilterProcessesUrl("/auth/login");
//        http.csrf(AbstractHttpConfigurer::disable);
//        http.authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/**").hasRole("USER")
//                        .requestMatchers("/auth/**").permitAll()
//                        .anyRequest().authenticated())
////                .oauth2Login(oauth2 -> oauth2
////                        .loginPage("/oauth2/authorization/github")
////                        .defaultSuccessUrl("/", true) // google.com || google.com/
////                        .userInfoEndpoint(userInfo -> userInfo.userService(this.customOAuth2UserService())))
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(this.jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//            throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
