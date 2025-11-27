package com.example.hello.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ProductDto {
    private String name;
    private int price;
    private int stock;
}
