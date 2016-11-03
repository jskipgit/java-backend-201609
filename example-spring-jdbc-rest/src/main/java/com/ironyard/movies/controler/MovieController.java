package com.ironyard.movies.controler;

import com.ironyard.movies.data.Movie;
import com.ironyard.movies.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jasonskipper on 10/10/16.
 */
@RestController
public class MovieController {

    private MovieService movieService = new MovieService();


    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public Movie save(@RequestBody Movie aMovie){
        Movie saved = null;
        try {
            movieService.save(aMovie);
            saved = movieService.getMovieById(aMovie.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saved;
    }

    @RequestMapping(value = "/movie/update", method = RequestMethod.PUT)
    public Movie update(@RequestBody Movie aMovie){
        Movie updated = null;
        try {
            movieService.update(aMovie);
            updated = movieService.getMovieById(aMovie.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public Movie show(@PathVariable Integer id){
        Movie found = null;
        try {
            found = movieService.getMovieById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> list(){
        List all = null;
        try {
            all = movieService.getAllMovies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    @RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.DELETE)
    public Movie delete(@PathVariable Integer id){
        Movie deleted = null;
        try {
            deleted = movieService.getMovieById(id);
            movieService.delete(id);
        } catch (SQLException e) {
            deleted  = null;
            e.printStackTrace();
        }
        return deleted;
    }
}
