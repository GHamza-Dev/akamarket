package com.akamarket.akamarket.helper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class Cookies{

    public static String get(HttpServletRequest request, String name){
        Map<String, Cookie> cookieMap = new HashMap<>();

        for(Cookie cookie : request.getCookies()){
            cookieMap.put(cookie.getName(),cookie);
        }

        Cookie cookie = cookieMap.get(name);
        return cookie != null ? cookie.getValue() : null;
    }

    public static void remove(HttpServletResponse response,String name){
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
