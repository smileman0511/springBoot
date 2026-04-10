package com.app.threetier;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.service.ProductService;
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
    public void registerProductTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductName("척70");
        productVO.setProductPrice(20000);
        productVO.setProductStock(10);
        productVO.setProductBrand("컨버스");
        productService.registerProduct(productVO);
    }
}
