<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/stylesheet/profile.css">
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
      <li><a href="#"><i class="fa-solid fa-house fa-lg" style="color: #000000;"></i> Home</a></li>
      <li><a href="#"><i class="fa-solid fa-cart-shopping fa-lg" style="color: #000000;"></i> Cart</a></li>
      <li><a href="#"><i class="fa-solid fa-circle-info fa-lg" style="color: #000000;"></i> About Us</a></li>
      <li><a href="#"><i class="fa-regular fa-user fa-lg" style="color: #000000;"></i> Profile</a></li>

    </ul>
  </nav>

  <section class="profile-container">
    <section class="profile">
      <div class="profile-box">
      <a href="editProfile.jsp">
        <button class="edit-profile-btn">Edit Profile</button>
        </a>
        <h1>Personal Details</h1>
        <section class="profile-picture">
          <img src="" alt="Profile Picture">
        </section>
        <div class="user-details">
          <p>Name: User Name</p>
          <p>Contact: +977 934567890</p>
          <p>Address: Putalisadak Kathmandu</p>
          <p>Date of Birth: YYYY-MM-DD</p>
          <p>Email: user@gmail.com</p>
          
          <button>Log Out</button>
        </div>
      </div>
    </section>

    <section class="order-history">
      <div class="order-history-box">
        <h1>Order History</h1>
        <div class="order-details">
          <div class="ordered-product">
            <img src="${pageContext.request.contextPath}/views/images/iphone.png" alt="Item Photo" class="item-photo">
            <div class="order-info">
              <span class="order-id">Iphone 15 Pro</span>
              <span class="status">Status: Delivered</span>
            </div>
            <button class="remove-button">Del</button>
          </div>
        </div>

      </div>
    </section>
  </section>
</body>
</html>