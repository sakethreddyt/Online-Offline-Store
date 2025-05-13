package com.store.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public String getAllProducts() {
        // TODO: Fetch product list from database
        return "List of products";
    }

    @PostMapping
    public String addProduct(@RequestBody String productDetails) {
        // TODO: Add product to database
        return "Product added: " + productDetails;
    }
}