package com.viongJewellery.domain.metal;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import lombok.Data;

@Data
public class MetalPriceEntity {
    private Long ID;
    private String METAL_TYPE;
    private LocalDate PRICE_DATE;
    private BigDecimal OFFICIAL_PRICE;
    private BigDecimal BUY_PRICE;
    private BigDecimal SELL_PRICE;
    private String UNIT;
    private Timestamp CREATED_AT;
    private Timestamp UPDATED_AT;
}
