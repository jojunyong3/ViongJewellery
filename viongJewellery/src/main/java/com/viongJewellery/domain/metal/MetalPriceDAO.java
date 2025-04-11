package com.viongJewellery.domain.metal;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MetalPriceDAO {

	
	MetalPriceEntity selectById(Long id);

    List<MetalPriceEntity> selectAll();

    int insert(MetalPriceEntity metalPrice);

    int update(MetalPriceEntity metalPrice);

    int delete(Long id);
    
    // 모든 금속에 대해 특정 날짜의 시세를 조회
    List<MetalPriceEntity> selectByDate(@Param("priceDate")  LocalDate date);
    
    
    
    List<MetalPriceEntity> selectByDateAndType(@Param("priceDate") LocalDate priceDate,
                                         @Param("metalType") String metalType);
}
