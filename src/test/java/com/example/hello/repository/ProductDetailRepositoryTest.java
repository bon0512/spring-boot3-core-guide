package com.example.hello.repository;

import com.example.hello.entity.Product;
import com.example.hello.entity.ProductDetail;
import com.example.hello.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductDetailRepositoryTest {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Test
    public void saveAndReadTest(){
        Product product = new Product();
        product.setName("스프링 부트 JPA");
        product.setPrice(5000);
        product.setStock(500);
        productRepository.save(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setDescription("스프링 부트와 같이 볼 수 있는 책");

        productDetailRepository.save(productDetail);

        System.out.println("saveProduct : "+productDetailRepository.findById(
                productDetail.getId()).get().getProduct());
        System.out.println("SaveProductDetail: "+productDetailRepository.findById(productDetail.getId()).get());
    }

    @Test
    void relationshipTest(){

        //테스트데이터 생성
        Provider provider = new Provider();
        provider.setName("00상사");

        providerRepository.save(provider);

        Product product1 = new Product();
        product1.setName("팬");
        product1.setPrice(2000);
        product1.setStock(100);
        product1.setProvider(provider);

        Product product2 = new Product();
        product2.setName("가방");
        product2.setPrice(20000);
        product2.setStock(200);
        product2.setProvider(provider);

        Product product3 = new Product();
        product3.setName("노트");
        product3.setPrice(3000);
        product3.setStock(1000);
        product3.setProvider(provider);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        List<Product> productList = providerRepository.findById(provider.getId()).get().getProductList();

        for (Product product : productList) {
            System.out.println(product);
        }

    }
}