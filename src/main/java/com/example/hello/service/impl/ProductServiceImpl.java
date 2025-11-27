package com.example.hello.service.impl;

import com.example.hello.dao.ProductDAO;
import com.example.hello.dto.ProductDto;
import com.example.hello.dto.ProductResponseDto;
import com.example.hello.entity.Product;
import com.example.hello.repository.ProductRepository;
import com.example.hello.service.ProductService;
import org.hibernate.sql.results.spi.LoadContexts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 제품 조회
    @Override
    public ProductResponseDto getProduct(Long number){
        Product product = productRepository.findById(number)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return new ProductResponseDto(product);
    }

    // 새 제품 저장
    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        return new ProductResponseDto(savedProduct);
    }

    // 제품 이름 변경
    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product product = productRepository.findById(number)
                .orElseThrow(() -> new Exception("Product not found"));

        product.setName(name);
        product.setUpdatedAt(LocalDateTime.now());

        Product updated = productRepository.save(product);

        return new ProductResponseDto(updated);
    }

    // 제품 삭제
    @Override
    public void deleteProduct(Long number) throws Exception {
        Product product = productRepository.findById(number)
                .orElseThrow(() -> new Exception("Product not found"));
        productRepository.delete(product);
    }
    /*private final ProductDAO productDAO;


    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;

    }


    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());

        return productResponseDto;

    }



    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changedProduct.getNumber());
        productResponseDto.setStock(changedProduct.getStock());
        productResponseDto.setPrice(changedProduct.getStock());
        productResponseDto.setName(changedProduct.getName());

        return productResponseDto;

    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }*/

}
