package com.geeksforgeeks.gfgpay.common.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Builder
@With
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID accountId;

    @JsonIgnore
    @OneToOne
    private User user;

    @Builder.Default
    private double balance = 0.0D;

    @Builder.Default
    private Instant createdAt = Instant.now();

    @Builder.Default
    private boolean kycComplete = false;

    public void send(Account receiverAccount, double amount) {
        if (this.equals(receiverAccount)) {
            this.balance += amount;
        } else {
            this.balance -= amount;
            receiverAccount.balance += amount;
        }
    }
}
