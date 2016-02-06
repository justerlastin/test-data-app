package org.testapp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testapp.bo.MovieCollectionBO;
import org.testapp.model.Movie;
import org.thymeleaf.util.StringUtils;

@Controller
public class MovieCollectionController {

	@Autowired
	private MovieCollectionBO movieCollectionBO;

	@RequestMapping("/movieCollection")
	public String identifyPeople(HttpServletRequest request, Model model) {
		List<String> movieTitles = new ArrayList<String>();
		movieCollectionBO.deleteAllMovieRecs();

		movieCollectionBO.saveMovie(new Movie("Inside Out", 2015));
		movieCollectionBO.saveMovie(new Movie("Hotel Translyvania 2", 2015));

		for (Movie movie : movieCollectionBO.findAllMovieRecs()) {
			movieTitles.add(movie.toString());
		}

		String movieTitlesStr = StringUtils.join(movieTitles, ", ");

		model.addAttribute("movieTitles", movieTitlesStr);
		return "movieCollection";
	}

}
