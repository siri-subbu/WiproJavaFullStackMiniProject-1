<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Task 14: Cash Back Offer</title></head>
<body>
    <h2>Cash Back Offer Calculation</h2>
    <form action="calculate-cashback" method="post">
        Bill Amount: <input type="number" step="0.01" name="billAmount" required /><br/><br/>
        Promo Code (e.g. CASH10, CASH20): <input type="text" name="promoCode" /><br/><br/>
        <input type="submit" value="Apply &amp; Calculate" />
    </form>
    <p><a href="./">Home</a></p>
</body>
</html>