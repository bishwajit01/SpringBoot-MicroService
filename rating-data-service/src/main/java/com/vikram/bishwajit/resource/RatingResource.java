package com.vikram.bishwajit.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.bishwajit.model.Rating;
import com.vikram.bishwajit.model.UserRating;

/**
 * @author Bishwajit.
 *
 */
@RestController
@RequestMapping("/ratings")
public class RatingResource {

	@GetMapping("/all")
	public List<Rating> getAllRatings() {
		return Collections.singletonList(new Rating("Bala", 4.3));
	}

	@GetMapping("/movies/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String id) {
		return new Rating(id, 3.8);
	}
	
	@GetMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String id) {
		UserRating userRating = new UserRating();
		userRating.initData(id);
		return userRating;
	}

}
