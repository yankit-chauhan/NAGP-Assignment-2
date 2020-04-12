package com.nagarro.orders.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nagarro.orders.dao.OrdersDAO;
import com.nagarro.orders.model.Order;
import com.nagarro.orders.service.OrderService;

/**
 * Provides implementation of Order Service
 * 
 * @author yankitchauhan
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrdersDAO ordersDao;

	@Value("${server.port}")
	private int port;

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getOrdersForUser(String userId) {
		logger.info("In OrderServiceImpl -> getOrdersForUser Method");
		logger.info("Working from port " + port + " of orders service");
		return ordersDao.getOrdersForUser(userId);
	}
}
