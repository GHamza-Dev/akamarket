package com.akamarket.akamarket.servlets.dept_manager;

import com.akamarket.akamarket.entity.Category;
import com.akamarket.akamarket.entity.DepartementManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PromotionServlet", value = "/dept-admin/promotions")
public class PromotionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartementManager deptManager = ((DepartementManager)request.getSession().getAttribute("person"));
        Category category = deptManager.getCategory();
        request.setAttribute("promotions",category.getPromotions());
        request.getRequestDispatcher("/dept.manager/promotions.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
