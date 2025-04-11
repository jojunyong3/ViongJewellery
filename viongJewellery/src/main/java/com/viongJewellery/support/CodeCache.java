package com.viongJewellery.support;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.viongJewellery.domain.code.Code;
import com.viongJewellery.domain.code.CodeService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CodeCache {

    private final Map<String, Map<String, String>> codeMap = new ConcurrentHashMap<>();
    private final CodeService codeService;


    @PostConstruct
    public void loadCodes() {
        reload(); // 초기 로딩 시 전체 갱신
    }

    //  전체 코드 캐시 갱신
    public void reload() {
        List<Code> allCodes = codeService.getAllCodes();

        Map<String, Map<String, String>> updatedMap = allCodes.stream()
                .collect(Collectors.groupingBy(
                        Code::getUpCode,
                        Collectors.toMap(Code::getCode, Code::getCodeName)
                ));

        codeMap.clear(); // 기존 캐시 삭제
        codeMap.putAll(updatedMap);
    }

    //  특정 코드 타입만 갱신
    public void reload(String type) {
        List<Code> codes = codeService.getCodesByType(type);

        if (codes != null && !codes.isEmpty()) {
            Map<String, String> codeNameMap = codes.stream()
                    .collect(Collectors.toMap(Code::getCode, Code::getCodeName));
            codeMap.put(type, codeNameMap);
        } else {
            codeMap.remove(type); // 해당 타입이 DB에 없으면 제거
        }
    }

    //  코드명 조회
    public String getCodeName(String upCode, String code) {
        return Optional.ofNullable(codeMap.get(upCode))
                .map(m -> m.get(code))
                .orElse(null);
    }

    //  타입별 전체 코드명 맵 조회 (프론트 드롭다운 등에 사용 가능)
    public Map<String, String> getCodeMapByType(String upCode) {
        return codeMap.getOrDefault(upCode, Collections.emptyMap());
    }
}
