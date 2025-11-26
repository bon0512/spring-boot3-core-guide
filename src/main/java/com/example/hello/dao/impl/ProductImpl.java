package com.example.hello.dao.impl;

import com.example.hello.dao.ProductDAO;
import com.example.hello.entity.Product;
import com.example.hello.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Component
public class ProductImpl implements ProductDAO {


    private final ProductRepository productRepository;


    @Autowired
    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product selectProduct(Long number) {
        return productRepository.getById(number);
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updateProduct;
        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();
            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        }else{
            throw new Exception();
        }

        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            productRepository.delete(product);
        }else{
            throw  new Exception();
        }
    }
}
