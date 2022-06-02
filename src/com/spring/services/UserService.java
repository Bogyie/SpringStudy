package com.spring.services;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response);
    ModelAndView registerForm(HttpServletRequest request, HttpServletResponse response);
    ModelAndView loginResult(HttpServletRequest request, HttpServletResponse response) throws Exception;
    ModelAndView registerResult(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
