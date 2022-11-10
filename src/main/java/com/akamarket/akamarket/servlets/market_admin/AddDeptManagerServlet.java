package com.akamarket.akamarket.servlets.market_admin;

import com.akamarket.akamarket.controller.Auth;
import com.akamarket.akamarket.controller.DeptManagerController;
import com.akamarket.akamarket.dao.CategoryDao;
import com.akamarket.akamarket.entity.Category;
import com.akamarket.akamarket.entity.Market;
import com.akamarket.akamarket.entity.MarketAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddDeptManagerServlet", value = "/market-admin/add-dept-manager")
public class AddDeptManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = new CategoryDao().getAll();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/market.admin/add.dept.manager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String category_id = request.getParameter("category-id");

        if (category_id == null || email == null || username == null) {
            return;
        }

        MarketAdmin marketAdmin = Auth.auth(request.getSession());
        Market market = marketAdmin.getMarket();

        DeptManagerController.addDeptManager(email,username,Integer.valueOf(category_id),market);
        this.doGet(request,response);
    }
}
