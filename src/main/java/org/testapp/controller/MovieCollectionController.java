package org.testapp.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.testapp.bo.MovieCollectionBO;
import org.testapp.model.Movie;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

@RestController
public class MovieCollectionController {

	@Autowired
	private MovieCollectionBO movieCollectionBO;

	@RequestMapping("/movieCollection")
	public List<Movie> identifyPeople(HttpServletRequest request, Model model) {
		return movieCollectionBO.findAllMovieRecs();
	}

	@RequestMapping(value = "/movie", produces = "application/json", method = RequestMethod.POST)
	public Movie createRandomMovieData() {
		String randomId = UUID.randomUUID().toString();
		Lorem lorem = LoremIpsum.getInstance();
		String randomTitle = lorem.getTitle(new Random().nextInt(5));
		while (StringUtils.isEmpty(randomTitle)) {
			randomTitle = lorem.getTitle(new Random().nextInt(5));
		}
		LocalDate randomDate = getRandomDate();

		Movie movie = new Movie();
		movie.setId(randomId);
		movie.setCountry(lorem.getCountry());
		movie.setDirector(lorem.getName());
		movie.setDvdReleaseDate(randomDate);
		movie.setGenre(getRandomGenre());
		movie.setLanguage("English");
		movie.setPlot(lorem.getParagraphs(1, 1));
		movie.setRating(getRandomRating());
		movie.setTitle(randomTitle);
		movie.setYear(String.valueOf(randomDate.getYear()));

		movieCollectionBO.saveMovie(movie);

		return movieCollectionBO.findByTitle(randomTitle);
	}

	private String getRandomGenre() {
		List<String> movieGenres = Arrays.asList("Action", "Adventure", "Animation", "Biography", "Comedy", "Crime",
				"Documentary", "Drama", "Family", "Fantasy", "Film Noir", "History", "Horror", "Music", "Musical",
				"Mystery", "Romance", "Sci-Fi", "Short", "Sport", "Superhero", "Thriller", "War", "Western");
		int genreIndex = new Random().nextInt(movieGenres.size() - 1);
		return movieGenres.get(genreIndex);
	}

	private String getRandomRating() {
		List<String> movieRatings = Arrays.asList("G", "PG", "PG-13", "R", "NC-17");
		int ratingIndex = new Random().nextInt(movieRatings.size() - 1);
		return movieRatings.get(ratingIndex);
	}

	private LocalDate getRandomDate() {
		long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
		long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		return randomDate.withYear(new Random().nextInt(38) + 1980);
	}

}
