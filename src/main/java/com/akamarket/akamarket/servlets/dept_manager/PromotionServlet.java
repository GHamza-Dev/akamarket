package com.akamarket.akamarket.servlets.dept_manager;

import com.akamarket.akamarket.controller.PromotionController;
import com.akamarket.akamarket.dao.DeptManagerDao;
import com.akamarket.akamarket.entity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "PromotionServlet", value = "/dept-admin/promotions")
public class PromotionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartementManager deptManager = ((DepartementManager)request.getSession().getAttribute("person"));

        PromotionController pController = new PromotionController();

        request.setAttribute("promotions",pController.getDeptManagerPromotions(deptManager));
        request.getRequestDispatcher("/dept.manager/promotions.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
