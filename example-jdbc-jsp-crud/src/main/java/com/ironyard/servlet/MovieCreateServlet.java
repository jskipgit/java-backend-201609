package com.ironyard.servlet;

import com.ironyard.data.Movie;
import com.ironyard.services.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jasonskipper on 10/4/16.
 */
public class MovieCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String destination = "/list";

        // get the data from request
        String name = req.getParameter("mName");
        String cat = req.getParameter("mCat");
        String sales = req.getParameter("mSales");

        // create a new movie object
        Movie myMovie = new Movie();
        myMovie.setCat(cat);
        myMovie.setName(name);
        myMovie.setSalesAmountMillions(Integer.parseInt(sales));

        // call save on movie service with our new object
        try {
            MovieService mServ = new MovieService();
            mServ.save(myMovie);
        }catch (Exception x){
            x.printStackTrace();
            destination = "/error.jsp";
        }
        // forward to list page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(req,resp);

    }
}
