package com.akamarket.akamarket.helper;

import com.akamarket.akamarket.controller.Auth;
import com.akamarket.akamarket.controller.PromotionController;
import com.akamarket.akamarket.entity.DepartementManager;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserAction {

    public static void onLoginSuccess(HttpServletRequest request, HttpServletResponse response){
        String hasBeenConnected = Cookies.get(request,"hasBeenConnected");

        if(hasBeenConnected == null || hasBeenConnected.equals("false")){
            Cookie cookie = new Cookie("hasBeenConnected","true");
            System.out.println("User logged in successfully!");
            response.addCookie(cookie);
        }
    }

    public static void onLogout(HttpServletRequest request,HttpServletResponse response){
        Cookies.remove(response,"hasBeenConnected");
        if(Auth.role(request.getSession()).equalsIgnoreCase("DepartementManager")){
            DepartementManager deptManager = Auth.auth(request.getSession());
            new PromotionController().setToNotTreated(deptManager);
        }
        System.out.println("User logged out successfully!");
    }
}
