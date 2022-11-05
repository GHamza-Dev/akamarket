package com.akamarket.akamarket.servlets.admin;

import com.akamarket.akamarket.dao.MarketDao;
import com.akamarket.akamarket.entity.Market;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/markets","/admin/add-market"})
public class AdminMarketsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Market> markets = new MarketDao().getAll();
        request.setAttribute("markets",markets);
        request.getRequestDispatcher("/admin/markets.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
