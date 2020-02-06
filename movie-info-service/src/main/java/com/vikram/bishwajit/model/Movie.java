package com.vikram.bishwajit.model;

/**
 * @author Bishwajit.
 *
 */
public class Movie {
	private String movieId;
	private String movieName;
	private String description;

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String movieId, String movieName, String description) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
