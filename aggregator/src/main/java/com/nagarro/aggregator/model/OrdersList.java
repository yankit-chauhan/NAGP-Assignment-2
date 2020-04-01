/**
 * 
 */
package com.nagarro.aggregator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yankitchauhan
 *
 */
public class OrdersList {
	private List<Order> orders;

	/**
	 * @param orders
	 */
	public OrdersList(List<Order> orders) {
		this.orders = orders;
	}
	
	public OrdersList() {
		this.orders = new ArrayList<>();
	}

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
