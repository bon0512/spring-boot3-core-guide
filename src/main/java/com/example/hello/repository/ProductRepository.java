package com.example.hello.repository;

import com.example.hello.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //find...By
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryByNumber(Long number);

    //exists...By
    boolean existsByNumber(Long number);

    //count ..by
    //조회 쿼리를 수행한 후 쿼리 결과로 나온 레코드의 개수를 리턴합니다.
    long countByName(String name);

    //delete.. by, remove...by
    // 삭제 쿼리를 수행합니다. 리턴 타입이 없거나 삭제한 횟수를 리턴합니다.
    void deleteByNumber(Long number);
    long removeByName(String name);

    // ...First<number>..., ...Top<number>...
    List<Product> findFirst5ByName(String name);
    List<Product> findTop10ByName(String name);

    //정렬 처리하기
    List<Product> findByNameOrderByNumberAsc(String name);
    List<Product> findByNameOrderByNumberDesc(String name);

    //조건이 여러개일때
    List<Product> findByNameOrderByPriceAscStockDesc(String name);


    //매개 변수를 이용한 쿼리 정렬
    List<Product> findByName(String name, Sort sort);

    //페이징 처리
    Page<Product> findByName(String name, Pageable pageable);

    @Query("SELECT p From Product p where p.name = :name")
    List<Product> findByNameParam(@Param("name") String name);

    @Query("Select p.name, p.price,p.stock FROM Product p where p.name = :name")
    List<Object[]> findByNameParam2(@Param("name") String name);
}
