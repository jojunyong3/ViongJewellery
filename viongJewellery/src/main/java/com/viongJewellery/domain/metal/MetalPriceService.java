package com.viongJewellery.domain.metal;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viongJewellery.domain.code.CodeDAO;
import com.viongJewellery.domain.code.CodeEntity;
import com.viongJewellery.domain.metal.dto.AdminDashBoardView;
import com.viongJewellery.domain.metal.dto.MetalPrice;
import com.viongJewellery.domain.metal.dto.PriceChangeResult;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetalPriceService {

	@Autowired
    private final MetalPriceDAO metalPriceDao;
    
	
	@Autowired
	private final CodeDAO codeDao;
    
    public MetalPrice getById(Long ID) {
        MetalPriceEntity result = metalPriceDao.selectById(ID);
        if (result == null) {
            throw new RuntimeException("해당 ID의 금속 시세 정보가 존재하지 않습니다: " + ID);
        }
        return new MetalPrice(result);
    }
    
    
    public MetalPrice getTodayPrice(String metalTypeCode)
    {
    	return getByDateAndType(LocalDate.now(),metalTypeCode).stream().findFirst().orElse(null);
    }
    
    
    /**
     * 관리자 메인페이지 뷰DTO 생성
     * @return
     */
    public List<AdminDashBoardView> getTodayPriceComparisonList() {
    	
    	List<MetalPrice> todayList = metalPriceDao.selectByDate(LocalDate.now())
    								 .stream().map(MetalPrice::new).toList();
    	
    	// 1. 금속 코드명 전체를 Map으로 미리 조회
    	Map<String, String> metalNameMap = codeDao.selectByUpCode("MT001").stream()
    	    .collect(Collectors.toMap(CodeEntity::getCODE, CodeEntity::getCODE_NAME));

 
    	
    	// 2. 어제 시세도 한 번에 조회해서 Map 으로
    	Map<String, MetalPrice> yesterdayPriceMap = metalPriceDao.selectByDate(LocalDate.now().minusDays(1))
    			.stream()
	    	    .map(MetalPrice::new)
	    	    .collect(Collectors.toMap(MetalPrice::getMetalType, mp -> mp));

    	// 3. 오늘 가격 리스트 기준으로 비교 및 뷰 구성
    	return todayList.stream().map(todayPrice -> {
    	    String metalType = todayPrice.getMetalType();
    	    MetalPrice yesterdayPrice = yesterdayPriceMap.get(metalType);

    	    PriceChangeResult result = todayPrice.compareTo(yesterdayPrice);
    	    String message = result.isComparable() ? "비교 성공" : "이전날 데이터가 없어 비교할 수 없습니다.";

    	    return new AdminDashBoardView(
    	        metalType,
    	        metalNameMap.getOrDefault(metalType, "알 수 없음"), // 한글 이름
    	        yesterdayPrice.getOfficialPrice(),
    	        todayPrice.getOfficialPrice(),
    	        result.getChangeAmount(),
    	        result.getChangeRate(),
    	        result.isComparable(),
    	        message
    	    );
    	}).collect(Collectors.toList());

    }

    
    public List<MetalPrice> getAll() {
        return metalPriceDao.selectAll().stream()
                .map(MetalPrice::new)
                .collect(Collectors.toList());
    }

    
    /**
     * 
     * @param PRICE_DATE 날짜
     * @param METAL_TYPE 금속타입 순금:MT00101 18k:MT00102 ...
     * @return
     */
    public List<MetalPrice> getByDateAndType(LocalDate PRICE_DATE, String METAL_TYPE) {
        return metalPriceDao.selectByDateAndType(PRICE_DATE, METAL_TYPE)
        		.stream()
                .map(MetalPrice::new)
                .collect(Collectors.toList());
    }
    
    

    public void create(MetalPrice metalPrice) {
        MetalPriceEntity entity = metalPrice.toEntity();
        int inserted = metalPriceDao.insert(entity);
        if (inserted != 1) {
            throw new RuntimeException("금속 시세 등록 실패");
        }
    }

    public void update(MetalPrice metalPrice) {
        MetalPriceEntity entity = metalPrice.toEntity();
        int updated = metalPriceDao.update(entity);
        if (updated != 1) {
            throw new RuntimeException("금속 시세 수정 실패");
        }
    }

    public void delete(Long ID) {
        int deleted = metalPriceDao.delete(ID);
        if (deleted != 1) {
            throw new RuntimeException("금속 시세 삭제 실패 또는 존재하지 않음: " + ID);
        }
    }
}
