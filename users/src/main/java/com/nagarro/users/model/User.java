package com.nagarro.users.model;

/**
 * User Model
 * 
 * @author yankitchauhan
 *
 */
public class User {

	private String userId;
	private String name;
	private Integer age;
	private String email;

	/**
	 * Constructor to create new Object of User
	 * 
	 * @param userId
	 * @param name
	 * @param age
	 * @param email
	 */
	public User(String userId, String name, Integer age, String email) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	/**
	 * Default Constructor
	 */
	public User() {

	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
