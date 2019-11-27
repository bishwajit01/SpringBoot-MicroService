package com.vikram.bishwajit.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vikram.bishwajit.model.CatalogItem;
import com.vikram.bishwajit.model.Movie;
import com.vikram.bishwajit.model.Rating;

/**
 * @author Bishwajit.
 *
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/all")
	public List<CatalogItem> getCatalog() {
		return Collections.singletonList(new CatalogItem("Bala", "About baldness", 4.3));
	}

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalogByUserId(@PathVariable("userId") String id) {

		// Get All rating movie id.
		List<Rating> ratingList = Arrays.asList(new Rating("1", 4.5));

		return ratingList.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8882/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getMovieName(), "About AGENTS", rating.getRating());
		}).collect(Collectors.toList());

		// return Collections.singletonList(new CatalogItem("Bala1", "About descrimination", 3.3));
	}
}
