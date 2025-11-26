package com.example.hello.service;

import com.example.hello.dto.ProductDto;
import com.example.hello.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
