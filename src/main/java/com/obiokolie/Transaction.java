package com.obiokolie;

public class Transaction {

	int orderID;
	String productID;
	int quantity;
	int price;
	String customerID;
	String orderDate;
	String paymentMethod;
	
	public Transaction(int orderID, String productID, int quantity, int price, String customerID, String orderDate,
			String paymentMethod) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.paymentMethod = paymentMethod;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
