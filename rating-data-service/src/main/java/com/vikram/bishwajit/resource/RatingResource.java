package com.vikram.bishwajit.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.bishwajit.model.Rating;

/**
 * @author bvikram2
 *
 */
@RestController
@RequestMapping("/ratings")
public class RatingResource {

	@GetMapping("all")
	public List<Rating> getAllRatings(@PathVariable("userId") String id) {
		return Collections.singletonList(new Rating("Bala", 4.3));
	}

	@GetMapping("{movieId}")
	public List<Rating> getCatalogByUserId(@PathVariable("movieId") String id) {
		return Collections.singletonList(new Rating(id, 3.8));
	}

}
