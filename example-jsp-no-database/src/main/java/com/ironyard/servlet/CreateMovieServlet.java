package com.ironyard.servlet;

import com.ironyard.data.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 9/20/16.
 */
public class CreateMovieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the data pieces
        String title = req.getParameter("title");
        String category = req.getParameter("cat");
        String imgUrl = req.getParameter("imgurl");
        String id = req.getParameter("id");

        HttpSession session = req.getSession();
        List<Movie> movieList = (List<Movie>) session.getAttribute("themovielist");

        if(movieList == null) {
            movieList = new ArrayList<>();
        }

        // look for it in the list
        Movie foundMovie = null;

        for(Movie m:movieList){
            if(m.getId() == Long.parseLong(id)){
                foundMovie = m;
                break;
            }
        }

        if(foundMovie == null) {
            // if movie not found, this is a new movie creation
            // create new movie object
            Movie myNewMovie = new Movie(title, category, imgUrl, Long.parseLong(id));
            movieList.add(myNewMovie);
        } else {
            // otherwise this is an update, so do update on object
            foundMovie.setCategory(category);
            foundMovie.setImgUrl(imgUrl);
            foundMovie.setTitle(title);
        }

        // save the movie object
        session.setAttribute("themovielist", movieList);

        // forword to result page
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/createMovie.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/createMovie.jsp");
        dispatcher.forward(req,resp);
    }
}
