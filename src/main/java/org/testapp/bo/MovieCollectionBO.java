package org.testapp.bo;

import java.util.List;

import org.springframework.stereotype.Component;
import org.testapp.model.Movie;

@Component
public interface MovieCollectionBO {

	public Movie findByTitle(String title);

	public List<Movie> findByReleasedYear(int releasedYear);

	public void deleteAllMovieRecs();

	public void saveMovie(Movie movie);

	public List<Movie> findAllMovieRecs();

}
