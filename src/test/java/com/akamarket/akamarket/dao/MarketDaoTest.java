package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.entity.Market;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarketDaoTest {
    @Test
    void get() {
        MarketDao marketDao = new MarketDao();
        assertEquals(1,marketDao.get(1).getId());
    }

    @Test
    void save() {
        MarketDao marketDao = new MarketDao();
        Market market = new Market();
        market.setCity("Tanger");
        marketDao.save(market);
        assertEquals(market,marketDao.get(market.getId()));
    }

}