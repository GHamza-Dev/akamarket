package com.akamarket.akamarket.helper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Consumer;

public class JPA {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public static void wrap(Consumer<EntityManager> action){
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        }catch (RuntimeException re){
            tx.rollback();
            throw re;
        }
    }

    public static EntityManagerFactory entityManagerFactory() {
        return emf;
    }

    public static EntityManager entityManager() {
        return em;
    }
}
