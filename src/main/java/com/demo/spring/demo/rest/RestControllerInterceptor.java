package com.demo.spring.demo.rest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class RestControllerInterceptor implements HandlerInterceptor {

    private final Logger logger = Logger.getLogger(RestControllerInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.log(Level.INFO, "[ " + request.getRequestURI() + " ]");
        return true;
    }
}
