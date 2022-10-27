package com.akamarket.akamarket.servlets.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;

@WebFilter("/*")
public class LogFilter implements Filter {
    private static int nbrOfRequests = 0;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest)request).getRequestURL().toString();

        nbrOfRequests++;
        System.out.println("[REQUEST START #"+nbrOfRequests+"]");
        System.out.println("Asked for: "+url);

        Enumeration enumeration = request.getParameterNames();
        System.out.println("Passed params:");
        int nbrOfParams = 0;
        while(enumeration.hasMoreElements()){
            String parameterName = (String) enumeration.nextElement();
            System.out.println("\t["+nbrOfParams+"]"+ parameterName +" = "+ request.getParameter(parameterName));
        }
        filterChain.doFilter(request, response);
        System.out.println("[REQUEST END #"+nbrOfRequests+"]");
    }
}
