package com.ironyard.servlet;

import com.ironyard.data.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jasonskipper on 9/20/16.
 */
public class DeleteMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get id of desired one to delete
        String deleteThisId = req.getParameter("nuke");
        long deleteId = Long.parseLong(deleteThisId);

        // get session list
        List<Movie> theMovieList = (List<Movie>) req.getSession().getAttribute("themovielist");
        // remove from list
        for(Movie m:theMovieList){
            if(m.getId() == deleteId){
                theMovieList.remove(m);
                break;
            }
        }

        // forward to create page
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/createMovie.jsp");
        dispatcher.forward(req,resp);

    }
}
