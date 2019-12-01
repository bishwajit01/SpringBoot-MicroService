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
import org.springframework.web.reactive.function.client.WebClient;

import com.vikram.bishwajit.model.CatalogItem;
import com.vikram.bishwajit.model.Movie;
import com.vikram.bishwajit.model.Rating;
import com.vikram.bishwajit.model.UserRating;

/**
 * @author Bishwajit.
 *
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping("/all")
	public List<CatalogItem> getCatalog() {
		return Collections.singletonList(new CatalogItem("Bala", "About baldness", 4.3));
	}

	@GetMapping("/restTemplate/{userId}")
	public List<CatalogItem> getCatalogByUserIdUsingRestTemplate(@PathVariable("userId") String id) {
		
		UserRating userRating = restTemplate.getForObject("http://localhost:8883/ratings/user/" + id, UserRating.class);
		
		return userRating.getRatings().stream().map(
				rating -> {
					Movie movie = restTemplate.getForObject("http://localhost:8882/movies/" + rating.getMovieId(), Movie.class);
					return new CatalogItem(movie.getMovieName(), "About AGENTS", rating.getRating());
				}).collect(Collectors.toList());

	}
	
	@GetMapping("/webClient/{userId}")
	public List<CatalogItem> getCatalogByUserIdUsingWebClient(@PathVariable("userId") String id) {
		// Get All rating movie id.
		List<Rating> ratingList = Arrays.asList(new Rating("1", 4.5));
		
		// Web Client in place of REST TEMPLATE
		// This is when we deal with asynchronous. 
		return ratingList.stream().map(rating -> {
			Movie movie = webClientBuilder.build()
							.get()  // Depends on the usage, GET POST PUT DELETE
							.uri("http://localhost:8882/movies/" + rating.getMovieId())
							.retrieve()
							.bodyToMono(Movie.class)
							.block(); // To block further more to execute the command, until it gets the values(esp. during the asynchronous).
			return new CatalogItem(movie.getMovieName(), "About AGENTS", rating.getRating());
		}).collect(Collectors.toList());
	}
}
