package com.vikram.bishwajit.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.bishwajit.model.Movie;

/**
 * @author Bishwajit.
 *
 */
@RestController
@RequestMapping("/movies")
public class MovieResource {

	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		return Collections.singletonList(new Movie("1", "Bala"));
	}
	
	@GetMapping("/{movieId}")
	public Movie getMoviesById(@PathVariable("movieId") String id) {
		return new Movie(id, "Bala");
	}
}
