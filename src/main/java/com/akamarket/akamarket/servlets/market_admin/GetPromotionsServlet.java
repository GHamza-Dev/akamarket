package com.akamarket.akamarket.servlets.market_admin;

import com.akamarket.akamarket.dao.MarketAdminDao;
import com.akamarket.akamarket.entity.MarketAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetPromotionsServlet", value = "/market-admin/promotions")
public class GetPromotionsServlet extends HttpServlet {
    private String url;

    @Override
    public void init() throws ServletException {
        this.url = getServletContext().getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("promotions",new MarketAdminDao().get(((MarketAdmin)request.getSession().getAttribute("person")).getId()).getPromotions());
        request.getRequestDispatcher("/market.admin/promotions.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
