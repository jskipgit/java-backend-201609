package com.ironyard.servlet;

import com.ironyard.data.User;
import com.ironyard.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by jasonskipper on 10/17/16.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user");
        String password = req.getParameter("pass");

        UserService uServ = new UserService();
        String dest = "/login.jsp";
        try {
            User found = uServ.getUserByNameAndPass(userName, password);
            if(found != null) {
                req.getSession().setAttribute("user", found);
                dest = "/list";
            }else {
                req.setAttribute("message", "Incorrect User Pass!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // forward to list page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dest);
        dispatcher.forward(req,resp);
    }
}
