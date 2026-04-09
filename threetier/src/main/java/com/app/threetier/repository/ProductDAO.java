package com.app.threetier.repository;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    public List<ProductVO> findAll() {
        return productMapper.selectAll();
    }

    public ProductVO findById(Long id) {
        return productMapper.selectById(id);
    }

    public void insertStuff(ProductVO productVO) {
        productMapper.insert(productVO);
    }
}