package com.akamarket.akamarket.filters;
import com.akamarket.akamarket.controller.Auth;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebFilter("/*")
public class RootFilter implements Filter {
    private static int nbrOfRequests = 0;
    private String url;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        this.url = filterConfig.getServletContext().getInitParameter("url");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        doLog(request);

        String requestedUrl = ((HttpServletRequest)request).getRequestURL().toString();
        String loginPageUrl = this.url+"index.jsp";
        String loginServletUrl = this.url+"login";

        if(Auth.auth(((HttpServletRequest)(request)).getSession()) == null && !loginPageUrl.equals(requestedUrl) && !loginServletUrl.equals(requestedUrl)){
            ((HttpServletResponse)response).sendRedirect("index.jsp");
            System.out.println("Unauthenticated...");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void doLog(ServletRequest request){
        String url = ((HttpServletRequest)request).getRequestURL().toString();

        nbrOfRequests++;
        System.out.println("[REQUEST START #"+nbrOfRequests+"] - Asked for: "+url);

        Enumeration enumeration = request.getParameterNames();
        System.out.println("Passed params:");
        int nbrOfParams = 0;
        while(enumeration.hasMoreElements()){
            nbrOfParams++;
            String parameterName = (String) enumeration.nextElement();
            System.out.println("\t["+nbrOfParams+"] "+ parameterName +" = "+ request.getParameter(parameterName));
        }
        System.out.println("[REQUEST END #"+nbrOfRequests+"]");
    }
}
