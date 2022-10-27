package com.akamarket.akamarket.servlets.market_admin;

import com.akamarket.akamarket.controller.PromotionController;
import com.akamarket.akamarket.dao.CategoryDao;
import com.akamarket.akamarket.dao.PromotionDao;
import com.akamarket.akamarket.entity.MarketAdmin;
import com.akamarket.akamarket.entity.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddPromotionServlet", value = "/market-admin/add-promotion")
public class AddPromotionServlet extends HttpServlet {
    private String url;

    @Override
    public void init() throws ServletException {
        this.url = getServletContext().getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories",new CategoryDao().getAll());
        request.getRequestDispatcher("/addpromotion.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.valueOf(request.getParameter("category_id"));
        Double percentage = Double.valueOf(request.getParameter("percentage"));
        int loyaltyPts = Integer.valueOf(request.getParameter("loyalty_pts"));
        Date avUntil = Date.valueOf(request.getParameter("av_until"));
        MarketAdmin marketAdmin = (MarketAdmin) request.getSession().getAttribute("person");

        try{
            new PromotionController().addPromotion(marketAdmin,categoryId,percentage,loyaltyPts,avUntil);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
