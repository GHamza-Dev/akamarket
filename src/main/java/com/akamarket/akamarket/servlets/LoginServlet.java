package com.akamarket.akamarket.servlets;

import com.akamarket.akamarket.controller.Auth;
import com.akamarket.akamarket.entity.DepartementManager;
import com.akamarket.akamarket.entity.MarketAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String roleInput = request.getParameter("role");

        if(email == null || password == null || roleInput == null){
            response.sendRedirect("index.jsp");
            return;
        }

        Class clazz = null;

        if (roleInput.equals("mkt-admin")) clazz = MarketAdmin.class;
        else if (roleInput.equals("dept-admin")) clazz = DepartementManager.class;
        else {
            response.sendRedirect("index.jsp");
            return;
        }

        if (Auth.authenticate(email,password,clazz,request.getSession())) {
            System.out.println("Logged in...");
        }else {
            response.sendRedirect("index.jsp");
        }
    }
}
