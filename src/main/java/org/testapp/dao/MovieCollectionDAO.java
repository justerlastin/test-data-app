package org.testapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.testapp.model.Movie;

public interface MovieCollectionDAO extends MongoRepository<Movie, String> {

	public Movie findByTitle(String title);

	public List<Movie> findByReleasedYear(Integer releasedYear);

}
