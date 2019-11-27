package com.vikram.bishwajit.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.bishwajit.model.Rating;

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

	@GetMapping("/{movieId}")
	public Rating getCatalogByUserId(@PathVariable("movieId") String id) {
		return new Rating(id, 3.8);
	}

}
