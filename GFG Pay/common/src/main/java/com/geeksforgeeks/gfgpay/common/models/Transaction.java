package com.geeksforgeeks.gfgpay.common.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transactionId;

    @ManyToOne
    private Account senderAccount;

    @ManyToOne
    private Account recieverAccount;

    private double amount;
    private boolean wasSuccessful;
    private Instant createdAt;

}
