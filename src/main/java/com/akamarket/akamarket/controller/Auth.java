package com.akamarket.akamarket.controller;

import com.akamarket.akamarket.dao.Authenticatable;
import jakarta.servlet.http.HttpSession;
public class Auth {
    public static<D> boolean authenticate(String email,String password, Class<D> clazz, HttpSession session){

        D person = Authenticatable.exist(email,password,clazz);

        if (person != null) {
            session.setAttribute("role",clazz);
            session.setAttribute("person",person);
            return true;
        }

        session.setAttribute("role",null);
        session.setAttribute("person",null);
        return false;
    }

    public static String role(HttpSession session){

        if(session.getAttribute("role") == null) return "";

        String strRole = session.getAttribute("role").toString();
        return strRole.substring(strRole.lastIndexOf(".")+1).toUpperCase();
    }

    public static <D> D auth(HttpSession session){
        return (D)session.getAttribute("person");
    }

    public static void kill(HttpSession session){
        session.invalidate();
    }
}
