package com.ironyard.movies.controler;

import com.ironyard.movies.data.MovieStat;
import com.ironyard.movies.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jasonskipper on 10/10/16.
 */
@RestController
public class MovieStatsController {

    private MovieService movieService = new MovieService();

    @RequestMapping(value = "/moviestats", method = RequestMethod.GET)
    public List<MovieStat> list(){
        List<MovieStat> stats = null;
        try {
            stats = movieService.getMovieStats();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }

}
