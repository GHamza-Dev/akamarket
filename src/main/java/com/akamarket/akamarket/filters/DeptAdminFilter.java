package com.akamarket.akamarket.filters;

import com.akamarket.akamarket.controller.Auth;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/dept-admin/*")
public class DeptAdminFilter implements Filter {

    private String url;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        this.url = filterConfig.getServletContext().getInitParameter("url");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if(!Auth.role(httpRequest.getSession()).equalsIgnoreCase("DepartementManager")){
            ((HttpServletResponse)response).sendRedirect(this.url+"404.jsp");
            System.out.println("Unauthenticated...");
            return;
        }

        chain.doFilter(request, response);
    }
}
