package com.akamarket.akamarket.servlets;

import com.akamarket.akamarket.controller.Auth;
import com.akamarket.akamarket.entity.DepartementManager;
import com.akamarket.akamarket.entity.MarketAdmin;
import com.akamarket.akamarket.helper.Alert;
import com.akamarket.akamarket.helper.AlertSession;
import com.akamarket.akamarket.helper.UserAction;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private String url;

    @Override
    public void init() throws ServletException {
        this.url = getServletContext().getInitParameter("url");
    }
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
        String toServlet = "";

        if (roleInput.equals("mkt-admin")) {
            clazz = MarketAdmin.class;
            toServlet = "market-admin/home";
        } else if (roleInput.equals("dept-admin")) {
            clazz = DepartementManager.class;
            toServlet = "dept-admin/home";
        } else {
            response.sendRedirect("index.jsp");
            return;
        }
        if (Auth.authenticate(email,password,clazz,request.getSession())) {
            UserAction.onLoginSuccess(request,response);
            response.sendRedirect(toServlet);
        }else {
            AlertSession.setAlert(new Alert("Wrong username or password!","error"),request.getSession());
            response.sendRedirect("index.jsp");
        }
    }
}
