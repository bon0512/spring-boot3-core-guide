package com.example.hello.controller;


import com.example.hello.entity.Member;
import com.example.hello.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    @PostMapping
    public Member addMember(@RequestBody Member member){
        return memberRepository.save(member);
    }

}
