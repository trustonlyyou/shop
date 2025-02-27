package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> { // <entity type, id type>

    List<Item> findByItemNm(String itemNm); // 상품명 이름 조회

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail); // 상품명 or 상품상세설명

    List<Item> findByPriceLessThan(Integer price); // 가격 Less than

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price); // 가격 내림 차순

    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailNative(@Param("itemDetail") String itemDetail);
}
