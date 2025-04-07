package com.viongJewellery.domain.code;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeDAO {

	List<CodeEntity> selectAll();

    CodeEntity selectByCode(String code);

    List<CodeEntity> selectByUpCode(String upCode);

    void insert(CodeEntity code);

    void update(CodeEntity code);

    void delete(String code);
	
}
