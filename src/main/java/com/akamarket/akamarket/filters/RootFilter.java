package com.akamarket.akamarket.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;

@WebFilter("/*")
public class RootFilter implements Filter {
    private static int nbrOfRequests = 0;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        doLog(request);

        if(((HttpServletRequest)(request)).getSession().getAttribute("person") == null){
            filterChain.doFilter(request, response);
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
