package com.nagarro.orders.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.orders.model.OrdersList;
import com.nagarro.orders.service.OrderService;

/**
 * Controller to expose various order related APIs.
 * 
 * @author yankitchauhan
 *
 */
@RestController
@RequestMapping(value = "/orders")
@EnableCircuitBreaker
public class OrdersController {
	
	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int port;

	@Autowired
	private OrderService orderService;

	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	/**
	 * Returns all orders of user
	 * 
	 * @param userId the User Id
	 * @return list of all orders placed by user
	 */
	@GetMapping
	OrdersList getOrdersForUser(@RequestParam(name = "userId") String userId) {
		logger.info("In OrdersController  -->>  getOrdersForUser Method");
		logger.info("In OrdersController  -->>  Getting Orders for User Id : " + userId);
		OrdersList orders = orderService.getOrdersForUser(userId);
		logger.info("Exiting OrdersController  -->>  getOrdersForUser Method");
		return orders;
	}
}
