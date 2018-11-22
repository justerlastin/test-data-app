package org.testapp.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Movie {

	@Id
	private String id;

	private String title;

	private String country;

	private LocalDate dvdReleaseDate;

	private String director;

	private String genre;

	private String language;

	private String plot;

	private String rating;

	private String year;

	public Movie() {
	}

	public Movie(String id, String title, String country, LocalDate dvdReleaseDate, String director, String genre,
			String language, String plot, String rating, String year) {
		super();
		this.id = id;
		this.title = title;
		this.country = country;
		this.dvdReleaseDate = dvdReleaseDate;
		this.director = director;
		this.genre = genre;
		this.language = language;
		this.plot = plot;
		this.rating = rating;
		this.year = year;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getDvdReleaseDate() {
		return dvdReleaseDate;
	}

	public void setDvdReleaseDate(LocalDate dvdReleaseDate) {
		this.dvdReleaseDate = dvdReleaseDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", country=" + country + ", dvdReleaseDate=" + dvdReleaseDate
				+ ", director=" + director + ", genre=" + genre + ", language=" + language + ", plot=" + plot
				+ ", rating=" + rating + ", year=" + year + "]";
	}

}
