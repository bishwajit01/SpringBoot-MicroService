package com.vikram.bishwajit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vikram.bishwajit.model.CatalogItem;
import com.vikram.bishwajit.model.Movie;
import com.vikram.bishwajit.model.Rating;

@Service
public class MovieInfo {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-api/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getMovieName(), "About AGENTS", rating.getRating());
	}

	public CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("NA", "N.A.", rating.getRating());
	}

}
