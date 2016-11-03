package com.ironyard.servlet;

import com.ironyard.data.Movie;
import com.ironyard.services.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by jasonskipper on 10/5/16.
 */
public class MovieDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/list";
        // get id from the request
        String id = req.getParameter("id");
        long idConv = Long.parseLong(id);

        // fetch movie by id
        MovieService ms = new MovieService();
        try {
            ms.delete(idConv);
        }catch(SQLException e){
            e.printStackTrace();
            destination = "/error.jsp";
        }

        // forward
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);
    }
}
