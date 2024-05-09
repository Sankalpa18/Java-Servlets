package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.User;
import model.product;
import util.stringUtils;

/**
 * Servlet implementation class DisplayProduct
 */
@WebServlet(asyncSupported = true, urlPatterns = stringUtils.DISPLAY_PRODUCT_SERVLET)
public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DatabaseController dbController = new DatabaseController();
	
	public DisplayProductServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
	    

	    // Check if the user is logged in
	    if (user != null) {
	        System.out.println("User is logged in. Retrieving products.");
	        
	        // Retrieve product data from the database
	        List<product> products = dbController.getAllProducts();
	       
	        // Set the products as an attribute in the request
	        request.setAttribute("products", products);
	      System.out.print(request.getContextPath() +  stringUtils.HOME_PAGE_LOGIN);
	     
	      
	      if (user.isAdmin()) {
	    	  request.getRequestDispatcher(stringUtils.ADMIN_PAGE).forward(request, response);
	      }
	      else {
	    	  request.getRequestDispatcher(stringUtils.HOME_PAGE_LOGIN).forward(request, response);
	      }
	      

//	      request.getRequestDispatcher(stringUtils.HOME_PAGE_LOGIN).forward(request, response);
	        
	       

	    } else {
	        // If user is not logged in, redirect to login page
	        response.sendRedirect(stringUtils.LOGIN_PAGE);
	    }
	}

}
