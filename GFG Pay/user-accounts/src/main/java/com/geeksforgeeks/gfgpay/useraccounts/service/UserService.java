package com.geeksforgeeks.gfgpay.useraccounts.service;

import com.geeksforgeeks.gfgpay.common.exceptions.NotFoundException;
import com.geeksforgeeks.gfgpay.useraccounts.model.User;
import com.geeksforgeeks.gfgpay.useraccounts.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;

    @Autowired
    public UserService(UserRepository userRepository, AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
    }

    @Transactional(rollbackFor = Exception.class)
    public User addUser(User user) {
        user = this.userRepository.save(user);
        this.accountService.addAccount(user);
        log.info("Added a new user with ID: {}", user.getUserId());
        return user;
    }

    public User getUserById(UUID userId) {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        return optionalUser.orElseThrow(() -> {
            NotFoundException ex = new NotFoundException(User.class, "userId", userId);
            log.info(ex.getMessage());
            return ex;
        });
    }
}
