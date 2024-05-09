package controller;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PasswordEncryptionWIthAes;
import model.User;
import model.cart;
import model.product;
import util.stringUtils;

public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		
		//Coursework Java 
		//Making the connection to the database
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_database"; //java_database is the name of the database
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }
	
	//this is the method which add the registered user to user database
    public int addStudent(User user) {
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(stringUtils.INSERT_STUDENT);

            PreparedStatement checkUsernameSt = con.prepareStatement(stringUtils.GET_USERNAME);
            checkUsernameSt.setString(1, user.getUserName());
            ResultSet checkUsernameRs = checkUsernameSt.executeQuery();

            checkUsernameRs.next();

            if (checkUsernameRs.getInt(1) > 0) {
                return -2; // Username already exists
            }

            PreparedStatement checkEmailSt = con.prepareStatement(stringUtils.GET_EMAIL);
            checkEmailSt.setString(1, user.getEmail());
            ResultSet checkEmailRs = checkEmailSt.executeQuery();

            checkEmailRs.next();

            if (checkEmailRs.getInt(1) > 0) {
                return -3; // Email already exists
            }

            // Encrypt password before storing it in the database
           String encryptedPassword = PasswordEncryptionWIthAes.encryptPassword(user.getPassword(), "U3CdwubLD5yQbUOG92ZnHw==");

            st.setString(1, user.getUserName());
            st.setString(2, user.getFirstName());
            st.setString(3, user.getLastName());
            st.setString(4, encryptedPassword);
            st.setString(5, user.getEmail());

            int result = st.executeUpdate();
            return result > 0 ? 1 : 0;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public User getLoginUserInfo(String username, String password) {

        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(stringUtils.GET_LOGIN_USER_INFO);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String userDb = rs.getString("username");
                String encryptedPassword = rs.getString("password");

                // Decrypt password from database and compare
                String decryptedPassword = PasswordEncryptionWIthAes.decryptPassword(encryptedPassword, "U3CdwubLD5yQbUOG92ZnHw==");

                if (decryptedPassword != null && userDb.equals(username) && decryptedPassword.equals(password)) {
                    // Create and return a User object
                    String firstName = rs.getString("firstname");
                    String lastName = rs.getString("lastname");
                    String email = rs.getString("email");
                    boolean isAdmin = rs.getBoolean("isAdmin");

                    User user = new User(username, firstName, lastName, password, email, isAdmin);
                    return user; // Login successful
                } else {
                    return null; // Password mismatch
                }
            } else {
                // No matching record found
                return null;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //methods for the iserting the data to table
    public int insertProduct(product prod) {
    	
    	int result=3;
        try (Connection conn = getConnection();
             PreparedStatement st = conn.prepareStatement(stringUtils.INSERT_PRODUCT)) {
            st.setString(1, prod.getName());
            st.setString(2, prod.getBrand());
            st.setInt(3, prod.getPrice());
            st.setString(4, prod.getDescription());
            st.setInt(5, prod.getStock());
            st.setString(6, prod.getImageUrlFromPart());
            st.setString(7, prod.getRAM());
            st.setString(8, prod.getROM());
            st.setString(9, prod.getProcessor());
            
            result = st.executeUpdate();
            
            
        }
        catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }
 
    
    //this is the code for the displaying the product items in front end
    //get the object of the product table
    public List<product> getAllProducts() {
        List<product> products = new ArrayList<>();
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(stringUtils.GET_PRODUCT);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int product_id= rs.getInt(1);
                String name=rs.getString(2);
                String brand=rs.getString(3);
                int price=rs.getInt(4);
                String description=rs.getString(5);
                int stock=rs.getInt(6);
                String productImage=rs.getString(7);
                String RAM=rs.getString(8);
                String ROM=rs.getString(9);
                String Processor=rs.getString(10);
                
                product products1=new product(product_id,name,brand,price,description,stock,productImage,RAM,ROM,Processor );
                products.add(products1);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging
        }
        return products;
    }

    ///descriptive product page
    ///also known as product overview
    public product getProductById(int id) {
        product product = null;
        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement(stringUtils.SELECT_PROD_BY_ID);
            // Set the product ID parameter
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int product_id = rs.getInt(1);
                String name = rs.getString(2);
                String brand = rs.getString(3);
                int price = rs.getInt(4);
                String description = rs.getString(5);
                int stock = rs.getInt(6);
                String productImage = rs.getString(7);
                String RAM = rs.getString(8);
                String ROM = rs.getString(9);
                String Processor = rs.getString(10);
                // Create a new Product object with the retrieved data
                product = new product(product_id, name, brand, price, description, stock, productImage, RAM, ROM, Processor);
                System.out.print(product);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // Log or handle the exception appropriately
        }
        return product;
    }

    //this is the db controller for the search functionality
    //search function by name
    public List<product> getResultFromSearch(String keyword){
		List<product> result = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(stringUtils.SEARCH_QUERRY);
			statement.setString(1,"%"+ keyword+"%");
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				int product_id=rs.getInt(1);
				String name = rs.getString(2);
                String brand = rs.getString(3);
                int price = rs.getInt(4);
                String description = rs.getString(5);
                int stock = rs.getInt(6);
                String productImage = rs.getString(7);
                String RAM = rs.getString(8);
                String ROM = rs.getString(9);
                String Processor = rs.getString(10);
                // Add the Product object to the results ArrayList
                product product = new product(product_id, name, brand, price, description, stock, productImage, RAM, ROM, Processor);
                result.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
    	}

    public int addProductToCart(cart cartModel) {
        try (Connection con = getConnection()) {
            PreparedStatement statement = con.prepareStatement(stringUtils.ADD_TO_CART_QUERY);
            statement.setInt(1, cartModel.getUserId());
            statement.setInt(2, cartModel.getProductId());
            statement.setString(3, cartModel.getProductName());
            statement.setInt(4, cartModel.getQuantity());
            statement.setInt(5, cartModel.getPice());
            int result = statement.executeUpdate();
            return result; // Return the number of rows affected
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return -1; // Return -1 to indicate an error
        }
    }

}

