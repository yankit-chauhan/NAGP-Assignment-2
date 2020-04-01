package com.nagarro.orders.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.orders.dao.OrdersDAO;
import com.nagarro.orders.model.Order;

/**
 * This class implements the methods of OrdersDAO to provide all orders present
 * in the system.
 * 
 * @author yankitchauhan
 *
 */
@Repository(value = "ordersDAO")
public class OrdersDAOImpl implements OrdersDAO{
	private static final Logger logger = LoggerFactory.getLogger(OrdersDAOImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getAllOrders() {
		logger.info("In OrdersDAOImpl  -->>  getAllOrders method");
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("1000001", "1", 0.0D, new Date(1582212873000L)));
		orders.add(new Order("1000002", "1", 0.0D, new Date(1582212873000L)));
		orders.add(new Order("1000003", "1", 0.0D, new Date(1582212873000L)));
		orders.add(new Order("1000004", "1", 0.0D, new Date(1582644873000L)));
		orders.add(new Order("1000005", "1", 0.0D, new Date(1582644873000L)));
		orders.add(new Order("1000006", "1", 0.0D, new Date(1582644873000L)));
		orders.add(new Order("1000007", "2", 0.0D, new Date(1584286473000L)));
		orders.add(new Order("1000008", "2", 0.0D, new Date(1584286473000L)));
		orders.add(new Order("1000009", "2", 0.0D, new Date(1584286473000L)));
		orders.add(new Order("1000010", "2", 0.0D, new Date(1585064073000L)));
		orders.add(new Order("1000011", "2", 0.0D, new Date(1585064073000L)));
		orders.add(new Order("1000012", "2", 0.0D, new Date(1585064073000L)));
		logger.info("Exiting OrdersDAOImpl  -->>  getAllOrders method");
		return orders;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getOrdersForUser(String userId) {
		logger.info("In OrdersDAOImpl  -->>  getOrdersForUser method");
		return getAllOrders().stream().filter(order -> order.getUserId().equalsIgnoreCase(userId))
				.collect(Collectors.toList());
	}
}
