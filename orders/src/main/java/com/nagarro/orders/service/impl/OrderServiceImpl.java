package com.nagarro.orders.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.orders.dao.OrdersDAO;
import com.nagarro.orders.model.OrdersList;
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

	@Resource
	private RestTemplate restTemplate2;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate2() {
		return new RestTemplate();
	}

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrdersList getOrdersForUser(String userId) {
		logger.info("In OrderServiceImpl -> getOrdersForUser Method");
		logger.info("Working from port " + port + " of orders service");
		OrdersList orders = new OrdersList(ordersDao.getOrdersForUser(userId));
		return orders;
	}
}
