package com.viongJewellery.domain.metal.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminDashBoardView {
    private String metalType;
    private String metalName;
    private BigDecimal yesterDayPrice;
    private BigDecimal todayPrice;
    private BigDecimal changeAmount;
    private BigDecimal changeRate;
    private boolean comparable;
    private String message;
}