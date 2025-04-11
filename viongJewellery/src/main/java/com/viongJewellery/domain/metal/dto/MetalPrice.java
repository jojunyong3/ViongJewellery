package com.viongJewellery.domain.metal.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.viongJewellery.domain.metal.MetalPriceEntity;
import com.viongJewellery.support.CodeCache;

import lombok.Data;

@Data
public class MetalPrice {

    private Long id;
    private String metalType;
    private String metalName;
    private LocalDate priceDate;
    private BigDecimal officialPrice;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
    private String unit;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Entity → DTO 생성자
    public MetalPrice(MetalPriceEntity entity) {
        this.id = entity.getID();
        this.metalType = entity.getMETAL_TYPE();
        this.priceDate = entity.getPRICE_DATE();
        this.officialPrice = entity.getOFFICIAL_PRICE();
        this.buyPrice = entity.getBUY_PRICE();
        this.sellPrice = entity.getSELL_PRICE();
        this.unit = entity.getUNIT();
        this.createdAt = entity.getCREATED_AT();
        this.updatedAt = entity.getUPDATED_AT();
    }

    // DTO → Entity 변환 메서드
    public MetalPriceEntity toEntity() {
        MetalPriceEntity entity = new MetalPriceEntity();
        entity.setID(this.id);
        entity.setMETAL_TYPE(this.metalType);
        entity.setPRICE_DATE(this.priceDate);
        entity.setOFFICIAL_PRICE(this.officialPrice);
        entity.setBUY_PRICE(this.buyPrice);
        entity.setSELL_PRICE(this.sellPrice);
        entity.setUNIT(this.unit);
        entity.setCREATED_AT(this.createdAt);     // 선택사항
        entity.setUPDATED_AT(this.updatedAt);     // 선택사항
        return entity;
    }
    
    
    //  metalName 까지 설정하는 팩토리 메서드
    public static MetalPrice from(MetalPriceEntity entity, CodeCache codeCache) {
        MetalPrice dto = new MetalPrice(entity);
        dto.metalName = codeCache.getCodeName("MT001", dto.getMetalType());
        return dto;
    }
    
    
    /*
     * 금,은 값을 비교한다.
     */
    public PriceChangeResult compareTo(MetalPrice other) {
        if (other == null || other.getOfficialPrice() == null) {
            return new PriceChangeResult(BigDecimal.ZERO, BigDecimal.ZERO);
        }

        BigDecimal changeAmount = this.officialPrice.subtract(other.getOfficialPrice());
        BigDecimal changeRate = BigDecimal.ZERO;

        if (other.getOfficialPrice().compareTo(BigDecimal.ZERO) > 0) {
            changeRate = changeAmount
                    .divide(other.getOfficialPrice(), 4, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
        }

        return new PriceChangeResult(changeAmount, changeRate);
    }
}

