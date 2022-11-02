package com.akamarket.akamarket.servlets.market_admin;

import com.akamarket.akamarket.dao.PromotionDao;
import com.akamarket.akamarket.entity.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetOnePromotionServlet", value = "/market-admin/promotion")
public class GetOnePromotionServlet extends HttpServlet {

    private String url;

    @Override
    public void init() throws ServletException {
        this.url = getServletContext().getInitParameter("url");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String promotionId = request.getParameter("promotion-id");

        if(promotionId == null){
            this.doGet(request,response);
            response.sendRedirect(this.url+"market-admin/promotions");
            return;
        }

       Promotion promotion = new PromotionDao().get(Integer.valueOf(promotionId));
       request.setAttribute("promotion",promotion);
       request.getRequestDispatcher("/market.admin/promotion.jsp").forward(request,response);

    }
}
