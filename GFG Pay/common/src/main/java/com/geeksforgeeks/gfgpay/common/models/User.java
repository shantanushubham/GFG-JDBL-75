package com.geeksforgeeks.gfgpay.common.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@With
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String name;

    private String phone;

    @JsonIgnore
    private String password;

    private String role;

    public String getUsername() {
        return this.phone;
    }
}
