package com.ironyard.filter;

import com.ironyard.data.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jasonskipper on 10/17/16.
 */
public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();

        HttpSession session = req.getSession(false);
        User usr = null;
        if(session != null ){
            usr = (User)session.getAttribute("user");
        }

        boolean allow = false;
        if(usr == null){
            // this person hasn't logged they can only get to /login or /login.jsp
            if(uri.endsWith("/login") || uri.endsWith("/login.jsp")) {
                allow = true;
            }
        }else{
            // already logged in
            allow = true;
        }

        if(allow){
            // send request on its way like normal
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else
        {
            // not auth, send to login
            res.sendRedirect("/movies/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
