package com.nagarro.aggregator.model;

import java.util.Date;

/**
 * Order Model to handle orders from Orders Microservice
 * 
 * @author yankitchauhan
 * 
 */
public class Order {
	
	private String orderCode;
	private String userId;
	private Double orderAmount;
	private Date orderDate;

	/**
	 * Constructor to create new object of Order
	 * 
	 * @param orderCode    the order code
	 * @param orderEntries the list of order entries
	 * @param totalPrice   the total price of order
	 * @param userId       the User Id
	 * @param status       the Order Status
	 */
	public Order(String orderCode, String userId, Double orderAmount, Date orderDate) {
		this.orderCode = orderCode;
		this.userId = userId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
	}

	/**
	 * Default Constructor
	 */
	public Order() {

	}

	/**
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * @param orderCode the orderCode to set
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the orderAmount
	 */
	public Double getOrderAmount() {
		return orderAmount;
	}

	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
