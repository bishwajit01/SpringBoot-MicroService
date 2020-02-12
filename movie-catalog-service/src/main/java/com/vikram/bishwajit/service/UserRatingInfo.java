package com.vikram.bishwajit.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vikram.bishwajit.model.Rating;
import com.vikram.bishwajit.model.UserRating;

@Service
public class UserRatingInfo {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(String id) {
		return restTemplate.getForObject("http://rating-service-api/ratings/user/" + id, UserRating.class);
	}

	public UserRating getFallbackUserRating(String id) {
		UserRating userRating = new UserRating();
		userRating.setUserId(id);
		userRating.setRatings(Arrays.asList(new Rating("0", 0)));
		return userRating;
	}
}
