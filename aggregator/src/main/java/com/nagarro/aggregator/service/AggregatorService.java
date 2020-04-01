package com.nagarro.aggregator.service;

import com.nagarro.aggregator.model.UserDetails;

/**
 * Interface that exposes various user and order related methods
 * 
 * @author yankitchauhan
 *
 */
public interface AggregatorService {

	UserDetails getDetails(String userId);
}
