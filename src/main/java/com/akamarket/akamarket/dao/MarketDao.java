package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.entity.Market;
import com.akamarket.akamarket.helper.JPA;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class MarketDao implements Dao<Market> {
    public Market get(int id){
        Market market = JPA.entityManager().find(Market.class,id);
        return market;
    }

    @Override
    public List<Market> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c FROM Market c");
        return query.getResultList();
    }

    @Override
    public void save(Market market) {
        JPA.wrap(em -> em.persist(market));
    }

    @Override
    public void update(Market market, String[] params) {
        market.setCity(Objects.requireNonNull(params[0], "City cannot be null"));
        JPA.wrap(entityManager -> entityManager.merge(market));
    }

    public void update(Market market, Consumer<Market>[] setters) {
        for (int i = 0; i < setters.length; i++) {
            setters[i].accept(market);
        }
        JPA.wrap(entityManager -> entityManager.merge(market));
    }

    @Override
    public void delete(Market market) {
        JPA.wrap(entityManager -> entityManager.remove(market));
    }
}
