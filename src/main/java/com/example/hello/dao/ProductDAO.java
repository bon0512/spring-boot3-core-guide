package com.example.hello.dao;

import com.example.hello.entity.Product;
import com.example.hello.repository.ProductRepository;

public interface ProductDAO {

    Product insertProduct(Product product);
    Product selectProduct(Long number);
    Product updateProductName(Long number,String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
