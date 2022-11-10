package com.akamarket.akamarket.servlets.market_admin;

import com.akamarket.akamarket.dao.DeptManagerDao;
import com.akamarket.akamarket.entity.DepartementManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetDeptManagersServlet", value = "/market-admin/dept-managers")
public class GetDeptManagersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DepartementManager> deptManagers = new DeptManagerDao().getAll();
        request.setAttribute("managers",deptManagers);
        request.getRequestDispatcher("/market.admin/dept.managers.jsp").forward(request,response);
    }

}
