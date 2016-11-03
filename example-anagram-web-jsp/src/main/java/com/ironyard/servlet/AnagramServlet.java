package com.ironyard.servlet;

import com.ironyard.service.AnagramChecker;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

/**
 * Created by jasonskipper on 10/13/16.
 */
public class AnagramServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // get parameters
        String oneWord = request.getParameter("oneWord");
        String anotherWord = request.getParameter("anotherWord");

        // check to see if anagram
        AnagramChecker myChecker = new AnagramChecker();
        boolean result = myChecker.isAnagram(anotherWord, oneWord);

        // save our data in the request
        request.setAttribute("isAnagram", result);

        // send this to a JSP
        String nextJSP = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }

}
