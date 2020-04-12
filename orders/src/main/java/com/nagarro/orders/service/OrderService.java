package com.nagarro.orders.service;

import java.util.List;

import com.nagarro.orders.model.Order;

/**
 * Interface to provide various order services.
 * 
 * @author yankitchauhan
 *
 */
public interface OrderService {

	/**
	 * Returns all orders of a user
	 * 
	 * @param userId the user id
	 * @return list of orders
	 */
	List<Order> getOrdersForUser(String userId);

}
