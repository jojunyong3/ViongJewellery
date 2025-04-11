package com.viongJewellery.domain.code;

import lombok.Data;

@Data
public class Code {

	
    private String code;
    private String codeName;
    private String upCode;
    private int sort;
    private String etc01;
    private String etc02;
    private String useYn;
    
    //  Entity → Domain 변환 생성자
    public Code(CodeEntity entity) {
        this.code = entity.getCODE();
        this.codeName = entity.getCODE_NAME();
        this.upCode = entity.getUP_CODE();
        this.sort = entity.getSORT();
        this.etc01 = entity.getETC01();
        this.etc02 = entity.getETC02();
        this.useYn = entity.getUSE_YN();
    }

    //  Domain → Entity 변환 메서드
    public CodeEntity toEntity() {
        CodeEntity entity = new CodeEntity();
        entity.setCODE(this.code);
        entity.setCODE_NAME(this.codeName);
        entity.setUP_CODE(this.upCode);
        entity.setSORT(this.sort);
        entity.setETC01(this.etc01);
        entity.setETC02(this.etc02);
        entity.setUSE_YN(this.useYn);
        return entity;
    }
}
