package org.testapp.model;

import org.springframework.data.annotation.Id;

public class Movie {

	@Id
	private String id;

	private String title;

	private Integer releasedYear;

	public Movie() {
	}

	public Movie(String title, Integer releasedYear) {
		this.title = title;
		this.releasedYear = releasedYear;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(Integer releasedYear) {
		this.releasedYear = releasedYear;
	}

	@Override
	public String toString() {
		return title + "[" + releasedYear + "]";
	}

}
