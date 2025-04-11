package com.viongJewellery.domain.code;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CodeService {

    private final CodeDAO codeDAO;

    public CodeService(CodeDAO codeDAO) {
        this.codeDAO = codeDAO;
    }

    // ✅ 전체 코드 조회 (Entity → Code 변환)
    @Transactional(readOnly = true)
    public List<Code> getAllCodes() {
        return codeDAO.selectAll()
                      .stream()
                      .map(Code::new)
                      .collect(Collectors.toList());
    }

    // ✅ 코드 타입별 조회 (Entity → Code 변환)
    @Transactional(readOnly = true)
    public List<Code> getCodesByType(String upCode) {
        return codeDAO.selectByUpCode(upCode)
                      .stream()
                      .map(Code::new)
                      .collect(Collectors.toList());
    }

    // ✅ 단일 코드 조회 (Entity → Code 변환)
    @Transactional(readOnly = true)
    public Code getCode(String code) {
        CodeEntity entity = codeDAO.selectByCode(code);
        return entity != null ? new Code(entity) : null;
    }

    // ✅ 등록 (Code → Entity 변환)
    @Transactional
    public void insertCode(Code code) {
        codeDAO.insert(code.toEntity());
    }

    // ✅ 수정 (Code → Entity 변환)
    @Transactional
    public void updateCode(Code code) {
        codeDAO.update(code.toEntity());
    }

    // ✅ 삭제
    @Transactional
    public void deleteCode(String code) {
        codeDAO.delete(code);
    }
}
