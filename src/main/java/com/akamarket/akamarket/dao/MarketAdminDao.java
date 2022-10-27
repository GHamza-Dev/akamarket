package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.entity.MarketAdmin;
import com.akamarket.akamarket.helper.JPA;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class MarketAdminDao implements Dao<MarketAdmin> {

    public MarketAdmin get(int id){
        MarketAdmin marketAdmin = JPA.entityManager().find(MarketAdmin.class,id);
        return marketAdmin;
    }

    @Override
    public List<MarketAdmin> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c FROM MarketAdmin c");
        return query.getResultList();
    }

    @Override
    public void save(MarketAdmin marketAdmin) {
        JPA.wrap(entityManager -> entityManager.persist(marketAdmin));
    }

    @Override
    public void update(MarketAdmin marketAdmin, String[] params) {
        marketAdmin.setEmail(Objects.requireNonNull(params[0], "Email cannot be null"));
        marketAdmin.setUsername(Objects.requireNonNull(params[1], "Username cannot be null"));
        marketAdmin.setPassword(Objects.requireNonNull(params[2], "Password cannot be null"));
        JPA.wrap(entityManager -> entityManager.merge(marketAdmin));
    }

    public void update(MarketAdmin marketAdmin, Consumer<MarketAdmin>[] setters) {
        for (int i = 0; i < setters.length; i++) {
            setters[i].accept(marketAdmin);
        }
        JPA.wrap(entityManager -> entityManager.merge(marketAdmin));
    }

    @Override
    public void delete(MarketAdmin marketAdmin) {
        JPA.wrap(entityManager -> entityManager.remove(marketAdmin));
    }
}
