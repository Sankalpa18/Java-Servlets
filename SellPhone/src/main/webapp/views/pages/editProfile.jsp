<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>

<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        input[type="text"],
        input[type="tel"],
        textarea,
        input[type="date"],
        input[type="email"],
        input[type="file"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>

</head>
<body>
	 <form action="#" method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="Name"><br><br>
        <input type="tel" name="contact" pattern="[0-9]{10}" placeholder="Contact"><br><br>
        <textarea name="address" placeholder="Address"></textarea><br><br>
        <input type="date" name="dob" placeholder="Date of Birth"><br><br>
        <input type="email" name="email" placeholder="Email"><br><br>
        <input type="file" name="profile_pic" accept="image/*" placeholder="Profile Picture"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>