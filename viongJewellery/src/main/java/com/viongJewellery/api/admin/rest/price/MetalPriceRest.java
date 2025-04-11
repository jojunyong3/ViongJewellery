package com.viongJewellery.api.admin.rest.price;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.viongJewellery.domain.metal.MetalPriceService;
import com.viongJewellery.domain.metal.dto.MetalPrice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin/metal-prices")
@RequiredArgsConstructor
public class MetalPriceRest {

    private final MetalPriceService metalPriceService;

    /**
     * 전체 시세 목록 조회
     */
    @GetMapping
    public ResponseEntity<List<MetalPrice>> getAll() {
        return ResponseEntity.ok(metalPriceService.getAll());
    }

    /**
     * ID로 단일 시세 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<MetalPrice> getById(@PathVariable Long id) {
        return ResponseEntity.ok(metalPriceService.getById(id));
    }

    
    @GetMapping("/paged")
    public ResponseEntity<PageInfo<MetalPrice>> getPaged(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
    	
    	PageHelper.startPage(page, size);
        List<MetalPrice> prices = metalPriceService.getAll();
        PageInfo<MetalPrice> pageInfo = new PageInfo<>(prices);
        
        return ResponseEntity.ok(pageInfo);
    }
    
    
    
    /**
     * 시세 등록
     */
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MetalPrice metalPrice) {
        metalPriceService.create(metalPrice);
        return ResponseEntity.created(URI.create("/api/admin/metal-prices")).build();
    }

    /**
     * 시세 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody MetalPrice metalPrice) {
        if (!metalPrice.getId().equals(id)) {
            return ResponseEntity.badRequest().build(); // URL과 body의 ID 불일치 방지
        }
        metalPriceService.update(metalPrice);
        return ResponseEntity.ok().build();
    }

    /**
     * 시세 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        metalPriceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
