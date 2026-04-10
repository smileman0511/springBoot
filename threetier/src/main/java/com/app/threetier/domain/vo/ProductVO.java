package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

//CREATE SEQUENCE SEQ_PRODUCT;
//CREATE TABLE TBL_PRODUCT(
//        ID NUMBER CONSTRAINT PK_PRODUCT PRIMARY KEY,
//        PRODUCT_NAME VARCHAR2(255) NOT NULL,
//PRODUCT_PRICE NUMBER DEFAULT 0,
//PRODUCT_STOCK NUMBER DEFAULT 999,
//PRODUCT_BRAND VARCHAR2(255)
//);


@Component
@Data
public class ProductVO {
    private Long id;
    private String productName;
    private int productPrice;
    private int productStock;
    private String productBrand;
}
