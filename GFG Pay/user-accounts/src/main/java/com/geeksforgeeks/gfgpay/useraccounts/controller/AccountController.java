package com.geeksforgeeks.gfgpay.useraccounts.controller;

import com.geeksforgeeks.gfgpay.common.exceptions.NotFoundException;
import com.geeksforgeeks.gfgpay.useraccounts.model.Account;
import com.geeksforgeeks.gfgpay.useraccounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/get_info")
    public ResponseEntity<Account> getAccountInfoByUser(@RequestParam UUID userId) {
        try {
            Account account = this.accountService.getAccountByUser(userId);
            return ResponseEntity.ok(account);
        } catch (NotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get_info/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID accountId) {
        try {
            Account account = this.accountService.getAccountById(accountId);
            return ResponseEntity.ok(account);
        } catch (NotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
