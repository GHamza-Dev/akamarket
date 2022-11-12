package com.akamarket.akamarket.servlets.market_admin;

import com.akamarket.akamarket.controller.PromotionController;
import com.akamarket.akamarket.dao.CategoryDao;
import com.akamarket.akamarket.entity.MarketAdmin;
import com.akamarket.akamarket.helper.Alert;
import com.akamarket.akamarket.helper.AlertSession;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

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
        request.getRequestDispatcher("/market.admin/addpromotion.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.valueOf(request.getParameter("category_id"));
        Double percentage = Double.valueOf(request.getParameter("percentage"));
        Date avUntil = Date.valueOf(request.getParameter("av_until"));
        MarketAdmin marketAdmin = (MarketAdmin) request.getSession().getAttribute("person");

        HashMap<String,String> errors = new HashMap<>();

        if(percentage > 50){
            errors.put("percentage_err","Discount should be less than or equal to 50%!");
        }

        if(new CategoryDao().get(categoryId).getCategoryName().equalsIgnoreCase("multimedia") && percentage > 20){
            errors.put("percentage_err","Discount should be less than or equal to 20% for multimedia category!");
            return;
        }

        if (!errors.isEmpty()) {
            request.setAttribute("categories",new CategoryDao().getAll());
            request.setAttribute("errors",errors);
            request.getRequestDispatcher("/market.admin/addpromotion.jsp").forward(request,response);
            return;
        }

        try{
            new PromotionController().addPromotion(marketAdmin,categoryId,percentage,avUntil);
            AlertSession.setAlert(new Alert("Promotion added successfully","success"),request.getSession());
        }catch (Exception e){
            AlertSession.setAlert(new Alert("Oops something went wrong please try again!","error"),request.getSession());
            e.printStackTrace();
        }finally {
            response.sendRedirect(url+"market-admin/promotions");
        }
    }
}
