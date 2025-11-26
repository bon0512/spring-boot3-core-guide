package com.example.hello.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProductDto {
    private String name;
    private int price;
    private int stock;
}
