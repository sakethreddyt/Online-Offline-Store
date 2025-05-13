package com.store.app.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.nio.file.Path;
import java.nio.file.Paths;

public class QRCodeGenerator {

    public static void generateQRCode(String data, String fileName) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 300, 300);
        
        Path path = Paths.get("src/main/resources/static/qr-codes/" + fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}