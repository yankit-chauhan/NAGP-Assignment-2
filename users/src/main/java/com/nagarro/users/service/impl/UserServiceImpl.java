package com.nagarro.users.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nagarro.users.dao.UsersDAO;
import com.nagarro.users.model.User;
import com.nagarro.users.service.UserService;

/**
 * Provides implementation of User Service.
 * 
 * @author yankitchauhan
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UsersDAO usersDao;

	@Value("${server.port}")
	private int port;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserDetails(String userId) {
		logger.info("In UserServiceImpl -> getUserDetails Method");
		logger.info("Working from port " + port + " of users service");
		return usersDao.getUserById(userId);
	}

}
