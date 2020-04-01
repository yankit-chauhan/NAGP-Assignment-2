/**
 * 
 */
package com.nagarro.users.dao;

import java.util.List;

import com.nagarro.users.model.User;

/**
 * Interface to define methods to provide access to Users database.
 * 
 * @author yankitchauhan
 *
 */
public interface UsersDAO {

	/**
	 * Get details of all users.
	 * @return Returns details of all users.
	 */
	List<User> getAllUsers();
	
	/**
	 * Returns details of user by searching it by userId.
	 * @param userId the User Id.
	 * @return The details of User.
	 */
	User getUserById(String userId);
}
