package com.akamarket.akamarket.servlets.dept_manager;

import com.akamarket.akamarket.controller.PromotionController;
import com.akamarket.akamarket.dao.DeptManagerDao;
import com.akamarket.akamarket.dao.PromotionDao;
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
import java.util.function.Consumer;
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
        String requestFor = request.getParameter("request-for");
        String promotionId = request.getParameter("promotion-id");

        if(requestFor == null || promotionId == null){
           this.doGet(request,response);
        }

        if(requestFor.equals("show")){
            Promotion promotion = new PromotionDao().get(Integer.valueOf(promotionId));
            request.setAttribute("promotion",promotion);
            request.getRequestDispatcher("/dept.manager/promotion.jsp").forward(request,response);
            return;
        }

        if(requestFor.equals("update-status")){
            String decision = request.getParameter("decision");
            String comment = request.getParameter("comment");
            String pId = request.getParameter("promotion-id");

            if (comment == null || decision == null || promotionId == null) {
                return;
            }

            Consumer<Promotion>[] setters = new Consumer[2];

            setters[0] = promotion -> promotion.setStatus(decision);
            setters[1] = promotion -> promotion.setDeptmanagercomment(comment);

            PromotionDao promotionDao = new PromotionDao();
            Promotion promotion = promotionDao.get(Integer.valueOf(pId));
            promotionDao.update(promotion,setters);

            request.getRequestDispatcher("/dept.manager/promotions.jsp").forward(request,response);
        }
    }
}
