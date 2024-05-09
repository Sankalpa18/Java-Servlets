<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/stylesheet/cart.css">
<script src="https://kit.fontawesome.com/6a838dbad0.js" ></script>
</head>
<body>
	 <header>
        <div class="logo">
            <a href=""><img src="${pageContext.request.contextPath}/views/images/logo.png" alt="logos"></a>
        </div>
        <div class="searchbox">
            <input type="text" class="S_text" placeholder="What are you looking for......">
            <button class="S_btn"><i class="fas fa-search"></i></button>
        </div>
            <button class="filter"><i class="fa-solid fa-square-caret-down fa-lg" style="color: #000000;"></i></button>
        <div class="icons">
            <a href=""><i class="fas fa-shopping-cart fa-xl" style="color: #000000;"></i></a>
            <a href=""><i class="fas fa-bell fa-xl" style="color: #000000;"></i></a>
            <a href=""><i class="fas fa-user fa-xl" style="color: #000000;"></i></a>
        </div>
    </header>
    
    <nav>
        <ul>
            <li><a href="#"><i class="fa-solid fa-house fa-lg" style="color: #000000;"></i>  Home</a></li>
            <li><a href="#"><i class="fa-solid fa-cart-shopping fa-lg" style="color: #000000;"></i>  Cart</a></li>
            <li><a href="#"><i class="fa-solid fa-circle-info fa-lg" style="color: #000000;"></i>  About Us</a></li>
            <li><a href="#"><i class="fa-regular fa-user fa-lg" style="color: #000000;"></i>  Profile</a></li>
            
        </ul>
    </nav>
    <div class="container">
        <div class="cart-items">
            <div class="product">
                <input type="checkbox" class="product-checkbox">
                <div class="item-image">
                    <img src="/iphone.png" alt="Product 1">
                </div>
                <div class="item-details">
                    <p class="item-desc" style="margin-left: 15%;">Iphone 15 pro</p>
                    <p class="item-price" style="margin-left: 65%;">$999.00</p>
                    <p class="item-quantity">
                        <button class="quantity-btn decrease" style="margin-left: 65%;">-</button>
                        <span class="quantity">1</span>
                        <button class="quantity-btn increase">+</button>
                    </p>
                </div>
                <div class="item-remove">
                    <button class="remove-btn">Remove</button>
                </div>
            </div>
        <div class="cart-total">
            <p>Total Price: $
                <span class="total-price">45.00</span> <!-- Total price calculation  -->
            </p>
        </div>
        <div class="checkout-buttons">
            <button class="add-more-btn">Add More Items</button>
            <button class="checkout-btn">Checkout</button>
        </div>
    </div>
	</div>
</body>
</html>