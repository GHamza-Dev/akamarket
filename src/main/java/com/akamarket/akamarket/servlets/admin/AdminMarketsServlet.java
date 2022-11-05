package com.akamarket.akamarket.servlets.admin;

import com.akamarket.akamarket.controller.MarketController;
import com.akamarket.akamarket.dao.MarketDao;
import com.akamarket.akamarket.entity.Market;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet({"/admin/markets","/admin/add-market-form","/admin/add-market"})
public class AdminMarketsServlet extends HttpServlet {

    private String url;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.url = config.getServletContext().getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestedUrl = request.getRequestURL().toString();

        if(requestedUrl.equals(this.url+"admin/markets")){
            List<Market> markets = new MarketDao().getAll();
            request.setAttribute("markets",markets);
            request.getRequestDispatcher("/admin/markets.jsp").forward(request,response);
        } else if (requestedUrl.equals(this.url+"admin/add-market-form")) {
            request.getRequestDispatcher("/admin/add.market.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        String address = request.getParameter("address");

        HashMap<String,String> errors = new HashMap<>();

        if(city == null){
            errors.put("city_err","City field is required!");
            System.out.println("city is impty");
        }

        if(address == null){
            errors.put("address_err","Address field is required!");
        }

        if(!errors.isEmpty()){
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("/admin/add.market.jsp").forward(request,response);
            return;
        }

        MarketController.addMarket(city,address);
        response.sendRedirect(this.url+"admin/markets");
    }
}
