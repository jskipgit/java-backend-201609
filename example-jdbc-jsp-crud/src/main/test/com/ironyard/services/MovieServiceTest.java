package com.ironyard.services;

import com.ironyard.data.Movie;
import com.ironyard.data.MovieStat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 10/3/16.
 */
public class MovieServiceTest {
    @Before
    public void setUp() throws Exception {
        DataBaseUtil dbUtil = new DataBaseUtil();
        Connection c = dbUtil.getConnection();
        Statement s = c.createStatement();
        s.executeUpdate("TRUNCATE movieinfo.movies");
        c.close();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllMovies() throws Exception {
        MovieService ms = new MovieService();
        List<Movie> allMovies = ms.getAllMovies();
        assertEquals(allMovies.size(), 1);
    }

    @Test
    public void getAllMovieStats() throws Exception {
        MovieService ms = new MovieService();
        List<MovieStat> stats = ms.getMovieStats();
        assertTrue(stats.size() > 0);
    }

    @Test
    public void searchMovieByCat() throws Exception {
        MovieService ms = new MovieService();
        List<Movie> allMovies = ms.search("sc");
        assertTrue(allMovies.size() > 0);
    }

    @Test
    public void testMultipleConnections() throws Exception {
        MovieService ms = new MovieService();
        List<Movie> allMovies = ms.search("sc");
        allMovies = ms.search("ac");
        allMovies = ms.search("ac");
        allMovies = ms.search("ac");
        allMovies = ms.search("ac");
        allMovies = ms.search("ac");
        allMovies = ms.search("ac");
    }

    @Test
    public void testSaveNewMovie() throws Exception {
        MovieService ms = new MovieService();
        Movie m = new Movie();
        m.setName("The Office xazifljif9");
        m.setCat("Comedy");
        m.setSalesAmountMillions(300);

        try {
            ms.save(m);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Movie> found = ms.search("The Office xazifljif9");
        assertNotNull(found);
        assertTrue(found.size() == 1);
        Movie foundMovie = found.get(0);
        assertEquals(foundMovie.getName(), "The Office xazifljif9");
        assertEquals(foundMovie.getCat(), "Comedy");
        assertEquals(foundMovie.getSalesAmountMillions(), 300);
        assertTrue(foundMovie.getId()>0);

    }

}