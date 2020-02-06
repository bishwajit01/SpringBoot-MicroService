package com.vikram.bishwajit.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vikram.bishwajit.model.Movie;
import com.vikram.bishwajit.model.MovieSummary;

/**
 * @author Bishwajit.
 *
 */
@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Value("${api.key}")
	private String apikey;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		return Collections.singletonList(new Movie("1", "Bala", "About Baldness"));
	}

	@GetMapping("/{movieId}")
	public Movie getMoviesById(@PathVariable("movieId") String id) {
		MovieSummary movieSummary = restTemplate
				.getForObject("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apikey, MovieSummary.class);
		System.out.println("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apikey);
		return new Movie(id, movieSummary.getTitle(), movieSummary.getOverview());
	}
}
