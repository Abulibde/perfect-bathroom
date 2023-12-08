package com.abulibde.perfectbathroom.web;

import com.abulibde.perfectbathroom.model.dto.productDTO.ProductSummaryDTO;
import com.abulibde.perfectbathroom.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public String allProducts(Model model, @PageableDefault(
            size = 3,
            sort = "price"
    ) Pageable pageable) {

        Page<ProductSummaryDTO> allProducts = productService.getAllProducts(pageable);
        model.addAttribute("products", allProducts);
        return "dining";
    }
}
