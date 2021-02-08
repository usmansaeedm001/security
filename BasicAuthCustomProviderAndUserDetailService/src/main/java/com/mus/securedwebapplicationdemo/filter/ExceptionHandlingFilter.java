package com.mus.securedwebapplicationdemo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class ExceptionHandlingFilter implements Filter {

    private final Logger logger = getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.error("Request is [{}]", servletRequest.toString());

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (IOException | ServletException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void destroy() {

    }
}
