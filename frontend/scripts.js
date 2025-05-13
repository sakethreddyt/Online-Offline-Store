document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("loginForm");
    const paymentForm = document.getElementById("paymentForm");
    const productList = document.getElementById("productList");
    
    // Login form submission
    if (loginForm) {
        loginForm.addEventListener("submit", async (e) => {
            e.preventDefault();
            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;
            
            const response = await fetch("/api/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, password }),
            });
            
            const result = await response.text();
            alert(result);
        });
    }
    
    // Payment form submission
    if (paymentForm) {
        paymentForm.addEventListener("submit", async (e) => {
            e.preventDefault();
            const upiId = document.getElementById("upiId").value;
            const amount = document.getElementById("amount").value;
            
            const response = await fetch(`/api/payment/generate-qr?upiId=${upiId}&amount=${amount}`);
            const result = await response.text();
            
            const qrCodeDiv = document.getElementById("qrCode");
            qrCodeDiv.innerHTML = `<p>${result}</p><img src="/static/qr-codes/upi-payment.png" alt="UPI QR Code">`;
        });
    }
    
    // Fetch and display products
    if (productList) {
        fetch("/api/products")
            .then((response) => response.json())
            .then((products) => {
                productList.innerHTML = products.map(product => `
                    <div class="product">
                        <h2>${product.name}</h2>
                        <p>${product.description}</p>
                        <p>Price: $${product.price}</p>
                        <img src="/static/qr-codes/product-${product.id}.png" alt="Product QR Code">
                    </div>
                `).join("");
            });
    }
});