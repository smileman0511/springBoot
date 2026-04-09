package com.app.threetier.mapper;

import com.app.threetier.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<ProductVO> selectAll();
    public ProductVO selectById(Long id);
    public void insert(ProductVO productVO);
}