package com.geeksforgeeks.gfgpay.useraccounts.service;

import com.geeksforgeeks.gfgpay.common.exceptions.NotFoundException;
import com.geeksforgeeks.gfgpay.useraccounts.model.Account;
import com.geeksforgeeks.gfgpay.useraccounts.model.User;
import com.geeksforgeeks.gfgpay.useraccounts.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account addAccount(User user) {
        Account account = Account.builder()
                .user(user)
                .build();
        account = this.accountRepository.save(account);
        log.info("Account with ID: {} for user with ID: {} was successfully created.", account.getAccountId(),
                user.getUserId());
        return account;
    }

    public Account getAccountById(UUID accountId) {
        Optional<Account> accountOptional = this.accountRepository.findById(accountId);
        return accountOptional.orElseThrow(() -> {
            NotFoundException ex = new NotFoundException(Account.class, "accountId", accountId);
            log.error(ex.getMessage());
            return ex;
        });
    }

    public Account getAccountByUser(User user) {
        return this.getAccountByUser(user.getUserId());
    }

    public Account getAccountByUser(UUID userId) {
        Optional<Account> accountOptional = this.accountRepository.findByUserId(userId);
        return accountOptional.orElseThrow(() -> new NotFoundException(Account.class, "userId", userId));
    }

}
