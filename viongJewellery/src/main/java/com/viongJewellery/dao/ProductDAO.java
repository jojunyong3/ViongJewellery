package com.viongJewellery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.viongJewellery.entity.ProductEntity;

@Mapper
public interface ProductDAO {

    // 전체 목록 조회 (name 조건 optional)
    List<ProductEntity> selectList(@Param("name") String name);    
    
    // 단건 조회
    ProductEntity selectOne(@Param("productNumber") String productNumber);
    
    // 등록
    int insert(ProductEntity product);

    // 수정
    int update(ProductEntity product);

    // 삭제
    int delete(@Param("productNumber") String productNumber);
}
