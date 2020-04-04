package com.nagarro.aggregator.service.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nagarro.aggregator.model.OrdersList;
import com.nagarro.aggregator.model.User;
import com.nagarro.aggregator.model.UserDetails;
import com.nagarro.aggregator.service.AggregatorService;

/**
 * @author yankitchauhan
 *
 */
@Service
public class AggregatorServiceImpl implements AggregatorService {

	@Value("${server.port}")
	private int port;

	@Value("${user.server.address}")
	private String userURL;

	@Value("${orders.server.address}")
	private String ordersURL;

	private static final Logger logger = LoggerFactory.getLogger(AggregatorServiceImpl.class);

	@Resource
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public UserDetails getDetails(String userId) {
		logger.info("In AggregatorServiceImpl  -->>  getDetails Method");
		String baseUserUrl = userURL + "/user";
		logger.info("Base User URL : " + baseUserUrl.toString());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> userResponse = null;

		try {
			UriComponentsBuilder userBuilder = UriComponentsBuilder.fromUriString(baseUserUrl).queryParam("userId",
					userId);
			logger.info(userBuilder.toString());
			userResponse = restTemplate.exchange(userBuilder.buildAndExpand().toUri(), HttpMethod.GET, null,
					User.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		String baseOrdersUrl = ordersURL + "/orders";
		logger.info("Base Orders URL : " + baseOrdersUrl.toString());
		ResponseEntity<OrdersList> ordersResponse = null;

		try {
			UriComponentsBuilder ordersBuilder = UriComponentsBuilder.fromUriString(baseOrdersUrl).queryParam("userId",
					userId);
			logger.info(ordersBuilder.toString());
			ordersResponse = restTemplate.exchange(ordersBuilder.buildAndExpand().toUri(), HttpMethod.GET, null,
					OrdersList.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		UserDetails details = null;
		if (Objects.nonNull(ordersResponse)) {
			details = new UserDetails(userResponse.getBody(), ordersResponse.getBody().getOrders());
		}

		logger.info("Exiting AggregatorServiceImpl  -->>  getDetails Method");
		return details;
	}

}
