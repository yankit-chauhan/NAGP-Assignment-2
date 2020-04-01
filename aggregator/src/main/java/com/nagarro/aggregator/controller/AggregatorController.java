package com.nagarro.aggregator.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.aggregator.model.OrdersList;
import com.nagarro.aggregator.model.User;
import com.nagarro.aggregator.model.UserDetails;
import com.nagarro.aggregator.service.AggregatorService;

/**
 * This controller contains all the methods to provide relevant User and Order
 * details.
 * 
 * @author yankitchauhan
 *
 */
@RestController
@RequestMapping(value = "/orderdetails")
@EnableCircuitBreaker
public class AggregatorController {

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int port;

	@Autowired
	AggregatorService aggregatorService;

	private static final Logger logger = LoggerFactory.getLogger(AggregatorController.class);

	@GetMapping(value = "/{code}")
	UserDetails getUserAndOrderDetails(@PathVariable(name = "code") String code) {
		logger.info("In AggregatorController  -->>  getUserAndOrderDetails Method");
		logger.info("User Id is : " + code);
		logger.info("Working from port " + port + " of aggregator service");
		return aggregatorService.getDetails(code);
	}

	@GetMapping(value = "/user/{userId}")
	public User getUserById(@PathVariable(name = "userId") String userId) {
		logger.info("In AggregatorController  -->>  getUserById Method");
		String url = "/user?userId=" + userId;

		url = "http://prices" + url;
		ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, null, User.class);
		User user = response.getBody();

		logger.info("Exiting AggregatorController  -->>  getUserById Method");
		return user;
	}

	@GetMapping(value = "/orders/{userId}")
	public OrdersList getOrdersForUserId(@PathVariable(name = "userId") String userId) {
		logger.info("In AggregatorController  -->>  getOrdersForUserId Method");
		String url = "/user?userId=" + userId;

		url = "http://prices" + url;
		ResponseEntity<OrdersList> response = restTemplate.exchange(url, HttpMethod.GET, null, OrdersList.class);
		OrdersList orders = response.getBody();

		logger.info("Exiting AggregatorController  -->>  getOrdersForUserId Method");
		return orders;
	}
}
