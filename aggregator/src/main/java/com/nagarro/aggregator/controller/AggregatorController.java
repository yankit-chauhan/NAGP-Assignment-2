package com.nagarro.aggregator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class AggregatorController {

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
}
