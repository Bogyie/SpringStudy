package com.spring.services;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServiceImpl implements UserService {
    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("loginForm");
    }

    public ModelAndView registerForm(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("registerForm");
    }

    public ModelAndView loginResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        request.setCharacterEncoding("utf-8");
        String userID = request.getParameter("userID");
        String passwd = request.getParameter("passwd");

        mav.addObject("userID", userID);
        mav.addObject("passwd", passwd);
        mav.setViewName("loginResult");
        return mav;
    }

    public ModelAndView registerResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        ModelAndView mav=new ModelAndView();
        String id=request.getParameter("id");
        String pwd=request.getParameter("pwd");
        String name=request.getParameter("name");
        String email=request.getParameter("email");

        mav.addObject("id",id);
        mav.addObject("pwd",pwd);
        mav.addObject("name",name);
        mav.addObject("email",email);
        mav.setViewName("registerResult");
        return mav;
    }
}
