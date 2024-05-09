package model;

public class cart {
    private int userId;
    private int productId;
    private String productName;
    private int quantity;
    private int pice;
    
	public cart(int userId, int productId, String productName, int quantity, int pice) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.pice = pice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPice() {
		return pice;
	}

	public void setPice(int pice) {
		this.pice = pice;
	}
    
}
