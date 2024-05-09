package controller.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.DatabaseController;
import model.cart;


@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController=new DatabaseController();

    public AddToCartServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve data from the request
        String userIdParam = request.getParameter("userId");
        String productIdParam = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String quantityParam = request.getParameter("quantity");
        String priceParam = request.getParameter("price");

        // Validate parameters
        if (userIdParam == null || productIdParam == null || quantityParam == null || priceParam == null ||
                userIdParam.isEmpty() || productIdParam.isEmpty() || quantityParam.isEmpty() || priceParam.isEmpty()) {
            // If any parameter is missing or empty, redirect to an error page
            response.sendRedirect("error.jsp");
            return;
        }

        // Parse parameters into integers
        int userId = Integer.parseInt(userIdParam);
        int productId = Integer.parseInt(productIdParam);
        int quantity = Integer.parseInt(quantityParam);
        int price = Integer.parseInt(priceParam);

        // Create a cartModel instance
        cart cartModel = new cart(userId, productId, productName, quantity, price);


        int result = dbController.addProductToCart(cartModel);
        System.out.print(result);
        // Respond to the client based on the result
        if (result == 1) {
            // Product added successfully
            response.sendRedirect("cart.jsp"); // Redirect to a success page or cart page
        } else if (result == 0) {
            // Product not added
            response.sendRedirect("error.jsp"); // Redirect to an error page
        } else {
            // Error occurred during the process
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }
		
	}