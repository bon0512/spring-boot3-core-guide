package com.example.hello.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class ProductResponseDto {
    private Long number;
    private String name;
    private int price;
    private int stock;
    public ProductResponseDto() {
    }
}
