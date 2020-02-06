package com.vikram.bishwajit.model;

import java.util.Arrays;
import java.util.List;

/**
 * @author Bishwajit.
 *
 */
public class UserRating {

	private String userId;
	private List<Rating> ratings;

	public void initData(String userId) {
		this.userId = userId;
		this.setRatings(Arrays.asList(new Rating("500", 2.9), new Rating("200", 4.9)));
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
	 * @return the ratings
	 */
	public List<Rating> getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
