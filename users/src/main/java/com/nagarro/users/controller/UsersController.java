package com.nagarro.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.users.model.User;
import com.nagarro.users.service.UserService;

/**
 * Controller to expose various user related APIs.
 * 
 * @author yankitchauhan
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UsersController {

	@Value("${server.port}")
	private int port;

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	/**
	 * Returns details of user
	 * 
	 * @param userId the User Id
	 * @return details of user
	 */
	@GetMapping
	User getUserDetails(@RequestParam(name = "userId") String userId) {
		logger.info("In UsersController  -->>  getUserDetails Method");
		logger.info("In UsersController  -->>  User Id is : " + userId);
		User user = userService.getUserDetails(userId);
		logger.info("Exiting UsersController  -->>  getUserDetails Method");
		return user;
	}
}
