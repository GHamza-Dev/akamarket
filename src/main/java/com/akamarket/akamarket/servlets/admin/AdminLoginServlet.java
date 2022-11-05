package com.akamarket.akamarket.servlets.admin;

import com.akamarket.akamarket.controller.Auth;
import com.akamarket.akamarket.entity.SuperAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/admin-login")
public class AdminLoginServlet extends HttpServlet {

    private String url;

    @Override
    public void init() throws ServletException {
        this.url = getServletContext().getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(this.url+"admin.login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Class clazz = SuperAdmin.class;

        if (Auth.authenticate(email,password,clazz,request.getSession())) {
            response.sendRedirect(this.url+"admin/home");
            System.out.println("Admin logged in successfully...");
        }else {
            response.sendRedirect(this.url+"admin.login.jsp");
        }
    }
}
