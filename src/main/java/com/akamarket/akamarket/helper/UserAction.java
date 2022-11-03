package com.akamarket.akamarket.helper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserAction {

    public static void onLoginSuccess(HttpServletRequest request, HttpServletResponse response){
        String hasBeenConnected = Cookies.get(request,"hasBeenConnected");

        if(hasBeenConnected == null || hasBeenConnected == "false"){
            Cookie cookie = new Cookie("hasBeenConnected","true");
            System.out.println("User logged in successfully!");
            response.addCookie(cookie);
        }
    }

    public static void onLogoutSuccess(HttpServletResponse response){
        Cookies.remove(response,"hasBeenConnected");
        System.out.println("User logged out successfully!");
    }
}
