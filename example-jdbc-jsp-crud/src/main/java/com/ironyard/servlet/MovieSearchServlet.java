package com.ironyard.servlet;

import com.ironyard.services.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by jasonskipper on 10/3/16.
 */
public class MovieSearchServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the movies
        MovieService ms = new MovieService();
        String destination = "/list.jsp";
        try {
            // get the search text
            String searchByText = req.getParameter("searchtext");

            req.setAttribute("movielist", ms.search(searchByText));
        } catch (SQLException e) {
            e.printStackTrace();
            destination = "/error.jsp";
        }

        // forward to proper JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);    }
}
