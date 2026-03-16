package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/add-product")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/save-product")
    public String saveProduct(@Valid Product product, BindingResult result) {

        if (result.hasErrors()) {
            return "add-product";
        }

        service.save(product);

        return "redirect:/products";
    }

    @GetMapping("/products")
    public String listProducts(
            @RequestParam(defaultValue = "") String brand,
            @RequestParam(defaultValue = "") String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "name") String sort,
            Model model) {

        Page<Product> products = service.getProducts(brand, category, page, sort);

        model.addAttribute("products", products);
        model.addAttribute("brand", brand);
        model.addAttribute("category", category);

        return "product-list";
    }

}