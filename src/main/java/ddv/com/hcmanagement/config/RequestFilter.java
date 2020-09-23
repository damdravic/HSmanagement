package com.bookstore.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        System.out.println("Pre-fight 1 step 1");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        System.out.println("Pre-fight 1 step 1");

        if(!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
            try {
                System.out.println("Pre-fight step 4");
                chain.doFilter(req, res);
                System.out.println("Pre-fight step 4");
            } catch (Exception e) {
                System.out.println("Pre-fight step 5");
                e.printStackTrace();
                System.out.println("Pre-fight step 5");
            }
        } else {
            System.out.println("Pre-fight step 2");
            response.setHeader("Access-Control-Allowed-Methods", "POST, GET, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, x-auth-token, " +
                    "access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }



    public void init(FilterConfig filterConfig) {}

    public void destroy() {}
}