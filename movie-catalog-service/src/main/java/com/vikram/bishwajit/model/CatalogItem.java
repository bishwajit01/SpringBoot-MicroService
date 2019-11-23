package com.vikram.bishwajit.model;

/**
 * @author bvikram2
 *
 */
public class CatalogItem {
	private String name;
	private String desc;
	private double rating;

	public CatalogItem(String name, String desc, double rating) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

}
