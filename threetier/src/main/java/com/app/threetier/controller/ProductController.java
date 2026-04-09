package com.app.threetier.controller;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/add")
    public String add(ProductVO productVO) {
        return "products/add";
    }

    @PostMapping("/add")
    public String add(ProductVO productVO, Model model) {
        productService.add(productVO);
        model.addAttribute("productVO", productVO);
        return "products/product";
    }
}