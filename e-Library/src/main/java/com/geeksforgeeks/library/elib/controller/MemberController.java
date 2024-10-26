package com.geeksforgeeks.library.elib.controller;

import com.geeksforgeeks.library.elib.entity.Member;
import com.geeksforgeeks.library.elib.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> memberList = this.memberService.getAllMembers();
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getBookById(@PathVariable UUID memberId) {
        Member member = this.memberService.getMemberById(memberId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Member> updateMember(@RequestBody Member member) {
        Member updatedMember = this.memberService.updateMember(member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

}
