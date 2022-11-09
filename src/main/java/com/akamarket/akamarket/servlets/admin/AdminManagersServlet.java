package com.akamarket.akamarket.servlets.admin;

import com.akamarket.akamarket.controller.MarketAdminController;
import com.akamarket.akamarket.controller.MarketController;
import com.akamarket.akamarket.dao.MarketAdminDao;
import com.akamarket.akamarket.dao.MarketDao;
import com.akamarket.akamarket.entity.Market;
import com.akamarket.akamarket.entity.MarketAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/add-manager-form","/admin/managers","/admin/add-manager"})
public class AdminManagersServlet extends HttpServlet {
    private String url;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.url = config.getServletContext().getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedUrl = request.getRequestURL().toString();

        if(requestedUrl.equals(this.url+"admin/managers")){
            List<MarketAdmin> marketAdmins = new MarketAdminDao().getAll();
            request.setAttribute("managers",marketAdmins);
            request.getRequestDispatcher("/admin/managers.jsp").forward(request,response);
        } else if (requestedUrl.equals(this.url+"admin/add-manager-form")) {
            List<Market> markets = MarketController.getMarketsWithNoAdmin();
            request.setAttribute("markets",markets);
            request.getRequestDispatcher("/admin/add.dept.manager.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String market_id = request.getParameter("market-id");

        if (market_id == null || email == null || username == null) {
            return;
        }

        MarketAdminController.addMarketAdmin(username,email,Integer.valueOf(market_id));
    }
}
