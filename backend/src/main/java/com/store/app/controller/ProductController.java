package com.store.app.controller;

import com.store.app.util.QRCodeGenerator;
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

    @PostMapping("/generate-qr")
    public String generateProductQR(@RequestParam String productId) {
        try {
            String productData = "Product ID: " + productId;
            QRCodeGenerator.generateQRCode(productData, "product-" + productId + ".png");
            return "QR Code generated successfully for Product ID: " + productId;
        } catch (Exception e) {
            return "Failed to generate QR Code: " + e.getMessage();
        }
    }
}