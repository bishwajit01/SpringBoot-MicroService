package com.vikram.bishwajit.model;

/**
 * @author Bishwajit.
 *
 */
public class Movie {
	private String movieId;
	private String movieName;

	public Movie() {
	}

	public Movie(String movieId, String movieName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
	}

	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}
