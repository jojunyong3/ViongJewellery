package com.viongJewellery.domain.metal.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PriceChangeResult {
	
    private BigDecimal changeAmount;
    private BigDecimal changeRate;
    private boolean comparable;
	    
    public PriceChangeResult(BigDecimal changeAmount, BigDecimal changeRate) {
        this.changeAmount = changeAmount;
        this.changeRate = changeRate;
        this.comparable = true;
    }
    
    public static PriceChangeResult empty() {
        return new PriceChangeResult(null, null,false); // 또는 0값 + "비교불가" 플래그
    }

}
