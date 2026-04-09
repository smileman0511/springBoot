package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @Test
    public void getProductTest() {
        log.info("product: {}", productService.getProduct(1L));
    }
}
