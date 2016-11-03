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
public class MovieUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/list";

        // get the request parameters
        String name = req.getParameter("mName");
        String cat = req.getParameter("mCat");
        String amount = req.getParameter("mSales");
        String id = req.getParameter("mId");

        int amountConv = Integer.parseInt(amount);
        long idConv = Long.parseLong(id);

        // create a movie object (with ID!)
        Movie updateMe = new Movie();
        updateMe.setId(idConv);
        updateMe.setSalesAmountMillions(amountConv);
        updateMe.setName(name);
        updateMe.setCat(cat);

        // call update on movie service
        MovieService ms = new MovieService();
        try {
            ms.update(updateMe);
        }catch (SQLException e){
            e.printStackTrace();
            destination = "/error.jsp";
        }
        // forward list
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);
    }
}
