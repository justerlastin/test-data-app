package org.testapp.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testapp.dao.MovieCollectionDAO;
import org.testapp.model.Movie;

@Component
public class MovieCollectionBOImpl implements MovieCollectionBO {

	@Autowired
	private MovieCollectionDAO movieCollectionDAO;

	public Movie findByTitle(String title) {
		Movie movie = movieCollectionDAO.findByTitle(title);
		return movie;
	}

	public List<Movie> findByYear(String releasedYear) {
		List<Movie> movieList = movieCollectionDAO.findByYear(releasedYear);
		return movieList;
	}

	public void deleteAllMovieRecs() {
		movieCollectionDAO.deleteAll();
	}

	public void saveMovie(Movie movie) {
		movieCollectionDAO.save(movie);
	}

	public List<Movie> findAllMovieRecs() {
		List<Movie> movielist = movieCollectionDAO.findAll();
		return movielist;
	}

}
