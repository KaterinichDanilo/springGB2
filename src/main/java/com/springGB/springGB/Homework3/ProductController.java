package com.springGB.springGB.Homework3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product")
    public String getProductById(Model model, @RequestParam(name = "id") Long id) {
        model.addAttribute("product", service.getProductById(id));
        return "product";
    }

    @GetMapping()
    public String showProducts(Model model) {
        model.addAttribute("products", service.getListProducts());
        return "/products";
    }

    @GetMapping("/new")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product) {
        service.add(product);
        return "redirect:/products";
    }
}
