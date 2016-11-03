package com.ironyard.servlet;

import com.ironyard.data.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jasonskipper on 9/21/16.
 */
@WebServlet(name = "SelectMovieServlet")
public class SelectMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get id of desired one to delete
        String selectThisMovieID = req.getParameter("id");
        long selectedId = Long.parseLong(selectThisMovieID);

        // get session list
        List<Movie> theMovieList = (List<Movie>) req.getSession().getAttribute("themovielist");
        // found movie reference
        Movie foundMovie = null;

        for(Movie m:theMovieList){
            if(m.getId() == selectedId){
                foundMovie = m;
                break;
            }
        }
        // put into request
        req.setAttribute("selectedmovie", foundMovie);

        // forward to create page
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/createMovie.jsp");
        dispatcher.forward(req,resp);
    }
}
