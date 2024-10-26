package com.geeksforgeeks.library.elib.service;

import com.geeksforgeeks.library.elib.entity.Member;
import com.geeksforgeeks.library.elib.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Autowired
    public MyUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    private final String PASSWORD = "$2a$12$apEgWjnWclilgI3s6Ik9aOwV7DIps1YhNLYKn6VqfGD6U/1bQWCxa";
//
//    private List<User> userList = Arrays.asList(
//            new User("member", PASSWORD, Collections.singletonList(new SimpleGrantedAuthority("ROLE_MEMBER"))),
//            new User("librarian", PASSWORD, Collections.singletonList(new SimpleGrantedAuthority("ROLE_LIBRARIAN"))));
//
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member = this.memberRepository.findByUsername(username);
        if (member.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Member with username: %s is not found.", username));
        }
        Member m = member.get();
        return User.builder()
                .username(m.getUsername())
                .password(m.getPassword())
                .roles(m.getRole())
                .build();
    }
}
