package com.springGB.springGB.Homework3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

//    @GetMapping("/product")
//    public String getProductById(Model model, @RequestParam(name = "id") Long id) {
//        model.addAttribute("product", service.getProductById(id));
//        return "product";
//    }
//
//    @GetMapping()
//    public String showProducts(Model model) {
//        model.addAttribute("products", service.getListProducts());
//        return "/products";
//    }
//
//    @GetMapping("/new")
//    public String addProduct(Model model) {
//        model.addAttribute("product", new Product());
//        return "new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("product") Product product) {
//        service.add(product);
//        return "redirect:/products";
//    }

    @GetMapping("/product/all")
    public List<Product> getAll(){
        return service.getListProducts();
    }

    @GetMapping("/product/change_price")
    public void changePrice(@RequestParam Long productId, @RequestParam Integer delta){
        service.changePrice(productId, delta);
    }

    @PostMapping("/product/add")
    public void addProductPost(@RequestBody Product product){
        service.getListProducts().add(product);
    }

    @GetMapping("/product/delete/{id}")
    public void delete(@PathVariable Long id) {
        Product product = service.getProductById(id);
        service.getListProducts().remove(product);
    }
}
