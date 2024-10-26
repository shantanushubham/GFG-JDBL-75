package com.geeksforgeeks.library.elib.service;

import com.geeksforgeeks.library.elib.dto.AuthDto;
import com.geeksforgeeks.library.elib.entity.Member;
import com.geeksforgeeks.library.elib.exceptions.IncorrectCredentialsException;
import com.geeksforgeeks.library.elib.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AuthenticationService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member login(AuthDto authDto) {
        Optional<Member> memberOptional = this.memberRepository.findByUsername(authDto.getUsername());
        if (memberOptional.isEmpty()) {
            throw new UsernameNotFoundException(String.format(
                    "Member with username: %s was not found", authDto.getUsername()));
        }
        Member member = memberOptional.get();
        if (!this.passwordEncoder.matches(authDto.getPassword(), member.getPassword())) {
            log.info("Password is incorrect");
            throw new IncorrectCredentialsException("Incorrect password provided");
        }
        return member;
    }

    public Member signUp(Member member) {
        log.info("Saving a new member.");
        member.setPassword(this.passwordEncoder.encode(member.getPassword()));
        Member savedMember = this.memberRepository.save(member);
        log.info("Saved a new member with ID: {}", member.getId());
        return savedMember;
    }
}
