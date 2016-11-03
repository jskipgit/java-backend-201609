package com.ironyard.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jasonskipper on 9/19/16.
 */
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get list of movies


        // put list somewhere  so JSP can see the data

        // now forward
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/movielist.jsp");
        dispatcher.forward(req,resp);

    }
}
