package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.exception.ProductException;
import com.app.threetier.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {ProductException.class, Exception.class})
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    public List<ProductVO> getProducts() {
        return productDAO.findAll();
    }

    @Override
    public ProductVO getProduct(Long id) {
        return productDAO.findById(id);
    }

    @Override
    public void add(ProductVO productVO) {
        productDAO.insertStuff(productVO);
    }
}