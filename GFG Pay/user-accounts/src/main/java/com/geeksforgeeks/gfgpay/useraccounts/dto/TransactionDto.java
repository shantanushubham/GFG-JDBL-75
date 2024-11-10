package com.geeksforgeeks.gfgpay.useraccounts.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TransactionDto {

    private UUID senderAccId;
    private UUID receiverAccId;
    private double amount;

}
