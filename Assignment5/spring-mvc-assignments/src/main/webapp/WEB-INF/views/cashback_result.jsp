<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Cash Back Summary</title></head>
<body>
    <h2>Bill &amp; Cash Back Summary</h2>
    <p>Original Amount: ₹${billAmount}</p>
    <p>Promo Code Applied: ${empty promoCode ? 'None' : promoCode}</p>
    <p style="color: green; font-weight: bold;">Cash Back Earned: ₹${cashback}</p>
    <h3>Final Payable: ₹${finalPayable}</h3>
    <p><a href="cashback">New Calculation</a> | <a href="./">Home</a></p>
</body>
</html>