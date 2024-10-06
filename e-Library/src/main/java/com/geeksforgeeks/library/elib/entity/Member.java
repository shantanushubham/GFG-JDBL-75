package com.geeksforgeeks.library.elib.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.geeksforgeeks.library.elib.enums.SubscriptionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    @Email
    @Column(unique = true)
    private String email;

    @Builder.Default
    private SubscriptionStatus subscriptionStatus = SubscriptionStatus.INACTIVE;
}
