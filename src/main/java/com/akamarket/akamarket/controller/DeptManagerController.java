package com.akamarket.akamarket.controller;

import com.akamarket.akamarket.dao.DeptManagerDao;
import com.akamarket.akamarket.entity.Category;
import com.akamarket.akamarket.entity.DepartementManager;
import com.akamarket.akamarket.helper.Mail;

public class DeptManagerController {
    public static void addDeptManager(String email,String username,int categoryId){
        DepartementManager deptManager = new DepartementManager();
        Category category = new Category();
        category.setId(categoryId);

        deptManager.setEmail(email);
        deptManager.setUsername(username);
        deptManager.setPassword("1234");

        deptManager.setCategory(category);

        new DeptManagerDao().save(deptManager);

        String message = "<p>You have been added as a department manager of marjane</p>" +
                "<p>Your password is: 1234</p>" +
                "Please go to: http://localhost:8080/akaMarket_war_exploded/index.jsp to change your password.";

        Mail.send("gassai.hamza@gmail.com","Test[Dept manager added successfully]",message);

    }
}
