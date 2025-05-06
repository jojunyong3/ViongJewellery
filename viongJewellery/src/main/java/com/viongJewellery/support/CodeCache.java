package com.viongJewellery.support;

import java.util.ArrayList;
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

    private final Map<String, List<Code>> codeMap = new ConcurrentHashMap<>();
    private final CodeService codeService;

    @PostConstruct
    public void loadCodes() {
        reload(); // 초기 로딩 시 전체 갱신
    }

    // 전체 코드 캐시 갱신
    public void reload() {
        List<Code> allCodes = codeService.getAllCodes();

        Map<String, List<Code>> updatedMap = allCodes.stream()
                .collect(Collectors.groupingBy(Code::getUpCode));

        codeMap.clear(); // 기존 캐시 삭제
        codeMap.putAll(updatedMap);
    }

    // 특정 코드 타입만 갱신
    public void reload(String type) {
        List<Code> codes = codeService.getCodesByType(type);

        if (codes != null && !codes.isEmpty()) {
            codeMap.put(type, codes);
        } else {
            codeMap.remove(type); // 해당 타입이 DB에 없으면 제거
        }
    }

    // 코드명 조회
    public String getCodeName(String upCode, String code) {
        return Optional.ofNullable(codeMap.get(upCode))
                .flatMap(list -> list.stream()
                        .filter(e -> e.getCode().equals(code))
                        .findFirst())
                .map(Code::getCodeName)
                .orElse(null);
    }

    // 타입별 전체 코드 목록 반환
    public List<Code> getCodeListByType(String upCode) {
        return codeMap.getOrDefault(upCode, Collections.emptyList());
    }

    // 특정 코드의 모든 하위 코드 재귀 탐색
    public List<Code> getAllDescendants(String upCode) {
        List<Code> result = new ArrayList<>();
        collectChildren(upCode, result);
        return result;
    }

    // 루트부터 전체 트리 반환
    public List<Code> getEntireCodeTree() {
        // 루트 노드라고 판단할 기준: upCode가 null 또는 "ROOT"
        List<Code> roots = codeMap.getOrDefault("ROOT", codeMap.getOrDefault(null, Collections.emptyList()));
        List<Code> result = new ArrayList<>();
        for (Code root : roots) {
            result.add(root);
            collectChildren(root.getCode(), result);
        }
        return result;
    }

    // 재귀적으로 하위 코드 수집
    private void collectChildren(String upCode, List<Code> result) {
        List<Code> children = codeMap.getOrDefault(upCode, Collections.emptyList());
        for (Code child : children) {
            result.add(child);
            collectChildren(child.getCode(), result); // 재귀 호출
        }
    }
}
