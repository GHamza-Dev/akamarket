package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.entity.Promotion;
import com.akamarket.akamarket.helper.JPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.function.Consumer;

public class PromotionDao implements Dao<Promotion>{

    public Promotion get(int id){
        Promotion promotion = JPA.entityManager().find(Promotion.class,id);
        return promotion;
    }

    @Override
    public List<Promotion> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c FROM Promotion c");
        return query.getResultList();
    }

    @Override
    public void save(Promotion promotion) {
        JPA.wrap(em -> em.persist(promotion));
    }

    @Override
    public void update(Promotion promotion, String[] params) {
        System.out.println("Working on it...");
        System.out.println("Please consider to use the overloaded update.");
    }

    public void update(Promotion promotion, Consumer<Promotion>[] setters) {
        for (int i = 0; i < setters.length; i++) {
            setters[i].accept(promotion);
        }
        JPA.wrap(entityManager -> entityManager.merge(promotion));
    }

    public void setStatusToNotTreated(int categoryId,int marketAdminId){
        EntityManager em = JPA.entityManager();
        EntityTransaction tx = em.getTransaction();
        Query query = em.createQuery("UPDATE Promotion p SET p.status = 'not-treated' WHERE p.status = 'pending' AND p.category.id ='"+categoryId+"' AND p.marketAdmin.id = '"+marketAdminId+"'");
        try {
            tx.begin();
            query.executeUpdate();
            tx.commit();
        }catch (RuntimeException re){
            tx.rollback();
            throw re;
        }finally {
            em.close();
        }
    }
    @Override
    public void delete(Promotion promotion) {
        JPA.wrap(entityManager -> entityManager.remove(promotion));
    }
}
