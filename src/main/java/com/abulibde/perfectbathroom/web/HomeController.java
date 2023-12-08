package com.abulibde.perfectbathroom.web;

import com.abulibde.perfectbathroom.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/home")
    public String  home(){

        return "home";
    }


}
