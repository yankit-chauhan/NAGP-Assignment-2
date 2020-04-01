package com.nagarro.orders.dao;

import java.util.List;

import com.nagarro.orders.model.Order;

/**
 * Interface to define methods to provide access to Orders database.
 * 
 * @author yankitchauhan
 *
 */
public interface OrdersDAO {

	/**
	 * Returns all orders
	 * 
	 * @return list of orders
	 */
	List<Order> getAllOrders();

	/**
	 * Returns all orders of a user
	 * 
	 * @param userId the user id
	 * @return list of orders
	 */
	List<Order> getOrdersForUser(String userId);

}
