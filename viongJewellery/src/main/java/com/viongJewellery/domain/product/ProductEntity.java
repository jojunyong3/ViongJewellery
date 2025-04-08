package com.viongJewellery.domain.product;

import lombok.Data;



/**
 * Product 테이블의 컬럼명과 일치 시키면 
 * mybatis에서 자동으로 해당 클래스의 객체를 생성하고 컬럼과 변수를 연결지어서 데이터를 넣어준다.
 */
@Data
public class ProductEntity {
	
    private int    SEQ;
    private String NAME;
    private int    HAND_EXPENSES;
    private int    WEIGHT;
    private int    SIZE;
    private int    STOCK;
    private String CONTENT;
    private String IMAGE;
    private String STATUS_CODE;
    private String CATEGORY_CODE;
}
