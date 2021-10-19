package com.example.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class specificFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(specificFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        logger.info("Specific Filter Used");
        chain.doFilter(request, response);
    }
}
