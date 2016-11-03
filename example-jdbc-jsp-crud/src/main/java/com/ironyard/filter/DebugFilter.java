package com.ironyard.filter;

import com.ironyard.data.Movie;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonskipper on 10/18/16.
 */
public class DebugFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // BEFORE applicaiton
        System.out.println("BEFORE");

        // go do my app work
        filterChain.doFilter(servletRequest, servletResponse);

        // AFTER application
        System.out.println("AFTER");
    }

    @Override
    public void destroy() {

    }
}
