package com.example.hello.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class MemberDto {
    private String name;
    private String email;
    private String organization;

}
