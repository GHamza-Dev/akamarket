package com.akamarket.akamarket.servlets;

import com.akamarket.akamarket.controller.Auth;
import com.akamarket.akamarket.helper.UserAction;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Auth.kill(request.getSession());
        UserAction.onLogoutSuccess(response);
        response.sendRedirect("index.jsp");
    }
}
