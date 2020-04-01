/**
 * 
 */
package com.nagarro.aggregator.model;

import java.util.List;

/**
 * UserDetails Model
 * 
 * @author yankitchauhan
 *
 */
public class UserDetails {

	private User user;
	private List<Order> orders;
	
	/**
	 * @param user
	 * @param orders
	 */
	public UserDetails(User user, List<Order> orders) {
		super();
		this.user = user;
		this.orders = orders;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
