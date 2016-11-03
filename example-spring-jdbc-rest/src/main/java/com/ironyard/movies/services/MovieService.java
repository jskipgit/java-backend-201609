package com.ironyard.movies.services;

import com.ironyard.movies.data.Movie;
import com.ironyard.movies.data.MovieStat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 10/3/16.
 * CREATE TABLE movies
 (
 mov_id INTEGER PRIMARY KEY NOT NULL,
 mov_name VARCHAR(255),
 mov_cat VARCHAR(255),
 mov_sales_millions INTEGER
 );
 */
public class MovieService {
    /**
     * Get all movies in the database
     * @return
     * @throws SQLException
     */
    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> found = new ArrayList<>();
        DataBaseUtil dbUtil = new DataBaseUtil();
        Connection c = dbUtil.getConnection();
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("SELECT * from movieinfo.movies");
        found = convertResultsToList(rs);

        return found;
    }

    /**
     * Retrieves Movies by using a starts with search on categories OR name.
     * @param search string to search by
     * @return returns a list List<Movie> always, may be empty if no results found.
     * @throws SQLException
     */
    public List<Movie> search(String search) throws SQLException {
        List<Movie> found = new ArrayList<>();
        DataBaseUtil dbUtil = new DataBaseUtil();
        Connection c = null;

        try {
            c = dbUtil.getConnection();
            // do a starts with search
            search = search + "%";
            PreparedStatement ps = c.prepareStatement("select * from movieinfo.movies WHERE (mov_cat ILIKE ?) OR (mov_name ILIKE ?);");
            ps.setString(1, search);
            ps.setString(2, search);
            ResultSet rs = ps.executeQuery();
            found = convertResultsToList(rs);
        }catch(SQLException t){
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
            c.close();

        }
        return found;
    }

    /**
     * Generate movie statistics based on all movies
     * @return
     * @throws SQLException
     */
    public List<MovieStat> getMovieStats() throws SQLException {
        List<MovieStat> found = new ArrayList<>();
        DataBaseUtil dbUtil = new DataBaseUtil();
        Connection c = dbUtil.getConnection();
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(
                "select mov_cat, sum(mov_sales_millions) as cat_total from movieinfo.movies group by mov_cat;");
        while(rs.next()){
            MovieStat tmp = new MovieStat();
            tmp.setCat(rs.getString("mov_cat"));
            tmp.setSalesAmountMill(rs.getInt("cat_total"));
            found.add(tmp);
        }

        return found;
    }

    private List<Movie> convertResultsToList(ResultSet rs) throws SQLException {
        List<Movie> found = new ArrayList<>();
        while(rs.next()){
            Movie tmp = new Movie();
            tmp.setName(rs.getString("mov_name"));
            tmp.setId(rs.getLong("mov_id"));
            tmp.setCat(rs.getString("mov_cat"));
            tmp.setSalesAmountMillions(rs.getInt("mov_sales_millions"));
            found.add(tmp);
        }
        return found;
    }

    /**
     * Saves a movie object to database.  It will auto gen
     * the new ID.
     *
     * NOTE: CREATE SEQUENCE movieinfo.MOVIES_SEQ;
     * @param myMovie
     * @throws SQLException
     */
    public void save(Movie myMovie) throws SQLException {
        DataBaseUtil myDba = new DataBaseUtil();
        Connection c = null;
        try{
            c = myDba.getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO movieinfo.movies " +
                    "(mov_id, mov_name, mov_cat, mov_sales_millions) VALUES (  nextval('movieinfo.MOVIES_SEQ'),?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);


            ps.setString(1, myMovie.getName());
            ps.setString(2, myMovie.getCat());
            ps.setInt(3, myMovie.getSalesAmountMillions());
            ps.executeUpdate();

            // now lets get the id
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                myMovie.setId(generatedKeys.getLong(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
            c.rollback();
            throw e;
        }finally {
            c.close();
        }
    }

    /**
     * Gets the specified movie by it's ID
     *
     * @param idConv
     * @return
     * @throws SQLException
     */
    public Movie getMovieById(long idConv) throws SQLException {
        DataBaseUtil dbUtil = new DataBaseUtil();
        Connection c = null;
        Movie foundById = null;

        try {
            c = dbUtil.getConnection();
            // do a starts with search
            PreparedStatement ps = c.prepareStatement("select * from movieinfo.movies WHERE mov_id = ?;");
            ps.setLong(1, idConv);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                foundById = new Movie();
                foundById.setName(rs.getString("mov_name"));
                foundById.setId(rs.getLong("mov_id"));
                foundById.setCat(rs.getString("mov_cat"));
                foundById.setSalesAmountMillions(rs.getInt("mov_sales_millions"));
            }
        }catch(SQLException t){
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
            c.close();

        }
        return foundById;    }

    /**
     * Updates the movie specified to the values specified in the parameter movie
     * @param aMove
     * @throws SQLException
     */
    public void update(Movie aMove) throws SQLException{
        DataBaseUtil dbUtil = new DataBaseUtil();
        Connection c = null;
        try {
            c = dbUtil.getConnection();
            // do a starts with search
            PreparedStatement ps = c.prepareStatement("UPDATE movieinfo.movies SET mov_name=?, mov_cat=?, mov_sales_millions=? WHERE mov_id = ?;");
            ps.setString(1, aMove.getName());
            ps.setString(2, aMove.getCat());
            ps.setInt(3,aMove.getSalesAmountMillions());
            ps.setLong(4, aMove.getId());
            ps.executeUpdate();
        }catch(SQLException t){
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
            c.close();

        }
    }

    /**
     * Deletes the specified movie
     * @param id
     * @throws SQLException
     */
    public void delete(long id) throws SQLException{
        DataBaseUtil dbUtil = new DataBaseUtil();
        Connection c = null;
        try {
            c = dbUtil.getConnection();
            // do a starts with search
            PreparedStatement ps = c.prepareStatement("DELETE FROM movieinfo.movies where mov_id=?");
            ps.setLong(1, id);
            ps.executeUpdate();
        }catch(SQLException t){
            t.printStackTrace();
            c.rollback();
            throw t;
        }finally {
            c.close();

        }
    }
}
