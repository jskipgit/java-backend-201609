package com.ironyard.servlet;

import com.ironyard.data.Movie;
import com.ironyard.data.MovieStat;
import com.ironyard.services.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by jasonskipper on 10/3/16.
 */
public class MovieStatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String destination = "/sum.jsp";
        try {
            MovieService ms = new MovieService();

            req.setAttribute("moviestats", ms.getMovieStats() );

            // old way
            //req.setAttribute("moviestats", calculateMovieStats() );

        } catch (SQLException e) {
            e.printStackTrace();
            destination = "/error.jsp";
        }

        // forward to proper JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);
    }

    /**
     * Iterates all movies from database and calculates stats
     * @return
     * @throws SQLException
     */
    private List<MovieStat> calculateMovieStats() throws SQLException{
        MovieService ms = new MovieService();
        // put stats into request scope
        List<Movie> all = ms.getAllMovies();

        // store movie sum by cat
        HashMap<String, Integer> movieStats = new HashMap<>();

        for(Movie tmpM: all){
            Integer totalSoFar = movieStats.get(tmpM.getCat());
            Integer totalNow = 0;
            if(totalSoFar == null || totalSoFar == 0){
                totalNow = tmpM.getSalesAmountMillions();
            }else{
                totalNow = totalSoFar + tmpM.getSalesAmountMillions();
            }
            movieStats.put(tmpM.getCat(), totalNow);
        }

        Set<String> keys = movieStats.keySet();
        List<MovieStat> statList = new ArrayList<>();
        for(String key:keys){
            MovieStat stat = new MovieStat();
            stat.setCat(key);
            stat.setSalesAmountMill(movieStats.get(key));
            statList.add(stat);
        }
        return statList;
    }
}
