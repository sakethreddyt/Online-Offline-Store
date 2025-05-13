package com.store.app.controller;

import com.store.app.util.QRCodeGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @GetMapping("/generate-qr")
    public String generatePaymentQR(@RequestParam String upiId, @RequestParam double amount) {
        try {
            String paymentData = "upi://pay?pa=" + upiId + "&am=" + amount;
            QRCodeGenerator.generateQRCode(paymentData, "upi-payment.png");
            return "QR Code generated successfully!";
        } catch (Exception e) {
            return "Failed to generate QR Code: " + e.getMessage();
        }
    }
}