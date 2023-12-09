package com.abulibde.perfectbathroom.web;

import com.abulibde.perfectbathroom.model.dto.productDTO.CreateProductDTO;
import com.abulibde.perfectbathroom.model.dto.productDTO.ProductSummaryDTO;
import com.abulibde.perfectbathroom.model.enums.CategoryEnum;
import com.abulibde.perfectbathroom.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("categories")
    public CategoryEnum[] categories() {
        return CategoryEnum.values();
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("createProductDTO")) {
            model.addAttribute("createProductDTO", new CreateProductDTO());
        }


        return "add-product";
    }

    @PostMapping("/add")
    public String add(@Valid CreateProductDTO createProductDTO,
                      BindingResult bindingResult,
                      RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("createProductDTO", createProductDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createProductDTO", bindingResult);

            return "redirect:/product/add";
        }

        long newProductId = productService.createProduct(createProductDTO);

        return "redirect:/";

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
