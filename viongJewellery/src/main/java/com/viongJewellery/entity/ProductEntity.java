package com.viongJewellery.entity;

import lombok.Data;



/**
 * Product 테이블의 컬럼명과 일치 시키면 
 * mybatis에서 자동으로 해당 클래스의 객체를 생성하고 컬럼과 변수를 연결지어서 데이터를 넣어준다.
 */
@Data
public class ProductEntity {
	
    private String PRODUCT_NUMBER;
    private String PRODUCT_NAME;
    private int    PRODUCT_PRICE;
    private int    PRODUCT_STCOK;
    private String PRODUCT_CONTENT;
    private String PRODUCT_IMAGE;
    private String PRODUCT_STATUS;

}
