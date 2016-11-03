package com.ironyard.servlet;

import com.ironyard.services.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by jasonskipper on 10/3/16.
 */
@WebServlet(name = "MovieListServlet")
public class MovieListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    /**
     * Fetches a list of movies from database and forwards to list page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the movies
        MovieService ms = new MovieService();
        String destination = "/list.jsp";
        try {
            // put into request scope
            request.setAttribute("movielist", ms.getAllMovies());
        } catch (SQLException e) {
            e.printStackTrace();
            destination = "/error.jsp";
        }

        // forward to proper JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request,response);
    }
}
