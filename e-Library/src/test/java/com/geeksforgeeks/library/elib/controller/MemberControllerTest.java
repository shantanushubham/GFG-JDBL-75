package com.geeksforgeeks.library.elib.controller;

import com.geeksforgeeks.library.elib.ELibraryApplication;
import com.geeksforgeeks.library.elib.entity.Member;
import com.geeksforgeeks.library.elib.enums.SubscriptionStatus;
import com.geeksforgeeks.library.elib.service.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@SpringBootTest(classes = ELibraryApplication.class)
public class MemberControllerTest {

    @MockBean
    private MemberService memberService;

    private final MemberController memberController;

    @Autowired
    public MemberControllerTest(MemberController memberController) {
        this.memberController = memberController;
    }

    static final Member member = Member.builder()
            .email("testEmail@email.com")
            .id(UUID.randomUUID())
            .firstName("Test FName")
            .lastName("Test LName")
            .mobileNumber("testNum")
            .subscriptionStatus(SubscriptionStatus.ACTIVE)
            .build();

    @Test
    void addMember_whenAValidMemberIsPassed_shouldReturnCREATED() {
        Mockito.when(this.memberService.addMember(member)).thenReturn(member);

        ResponseEntity<Member> responseEntity = this.memberController.addMember(member);

        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        Assertions.assertEquals(member, responseEntity.getBody());
    }
}
