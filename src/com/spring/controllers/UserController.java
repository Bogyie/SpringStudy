package com.spring.controllers;

import com.spring.services.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends MultiActionController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {
        return userService.loginForm(request, response);
    }

    public ModelAndView registerForm(HttpServletRequest request, HttpServletResponse response) {
        return userService.registerForm(request, response);
    }

    public ModelAndView loginResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return userService.loginResult(request, response);
    }

    public ModelAndView registerResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return userService.registerResult(request, response);
    }
}
