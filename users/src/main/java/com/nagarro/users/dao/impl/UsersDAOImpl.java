/**
 * 
 */
package com.nagarro.users.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nagarro.users.dao.UsersDAO;
import com.nagarro.users.model.User;

/**
 * This class implements the methods of UsersDAO to provide all Users present in
 * the system.
 * 
 * @author yankitchauhan
 *
 */
@Repository(value = "usersDAO")
public class UsersDAOImpl implements UsersDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UsersDAOImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() {
		logger.info("In UsersDAOImpl  -->>  getAllUsers method");
		List<User> users = new ArrayList<>();
		users.add(new User("1", "Yankit", Integer.valueOf(26), "yankit@gmail.com"));
		users.add(new User("2", "Rahul", Integer.valueOf(26), "rahul@gmail.com"));
		logger.info("Exiting UsersDAOImpl  -->>  getAllUsers method");
		return users;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserById(String userId) {
		logger.info("In UsersDAOImpl  -->>  getUserById method");
		User user = null;
		Optional<User> userOptional = getAllUsers().stream().filter(u -> u.getUserId().equalsIgnoreCase(userId))
				.findFirst();
		if (userOptional.isPresent()) {
			logger.info("User found with userId : " + userId);
			user = userOptional.get();
		} else {
			logger.info("User not found with userId : " + userId);
		}
		logger.info("Exiting UsersDAOImpl  -->>  getUserById method");
		return user;
	}

}
