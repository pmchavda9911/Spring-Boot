package com.example.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(3)
public class usingFilter2 implements Filter {

    Logger logger = LoggerFactory.getLogger(UsingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        logger.info("Filter 2 is called");
        chain.doFilter(request, response);
    }
}
