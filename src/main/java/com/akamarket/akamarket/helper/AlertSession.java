package com.akamarket.akamarket.helper;

import jakarta.servlet.http.HttpSession;
public class AlertSession {

    public static void setAlert(Alert alert, HttpSession session){
        session.setAttribute("alert",alert);
    }

    public static Alert alert(HttpSession session){
        Alert alert = (Alert) session.getAttribute("alert");
        session.removeAttribute("alert");
        return alert;
    }

    public static boolean isSet(HttpSession session){
        return session.getAttribute("alert") != null ? true : false;
    }
}
