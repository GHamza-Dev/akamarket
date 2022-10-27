package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.helper.JPA;
import jakarta.persistence.Query;

public class Authenticatable {

    public static<A> A exist(String email, String password,Class<A> clazz){
        Query query = JPA.entityManager().createQuery("SELECT ma FROM "+ clazz.getSimpleName() +" ma WHERE ma.email = '"+email+"' AND ma.password = '"+password+"'");
        try {
            return (A) query.getResultList().get(0);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }
}
