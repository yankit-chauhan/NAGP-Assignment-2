/**
 * 
 */
package com.nagarro.users.service;

import com.nagarro.users.model.User;

/**
 * Interface to provide various user services.
 * 
 * @author yankitchauhan
 *
 */
public interface UserService {
	
	/**
	 * Returns User Details.
	 * 
	 * @param userId the User Id.
	 * @return The User details.
	 */
	User getUserDetails(String userId);
}
