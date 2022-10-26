package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.entity.Promotion;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PromotionDaoTest {

    @Test
    void save() {
        CategoryDao categoryDao = new CategoryDao();
        PromotionDao promotionDao = new PromotionDao();
        Promotion promotion = new Promotion();
        promotion.setCategory(categoryDao.get(1));
        promotion.setAvUntile(Date.valueOf("2022-12-02"));
        promotion.setPercentage(12d);
        promotion.setLoyaltyPts(3);
        promotion.setMarketAdmin(new MarketAdminDao().get(1));
        promotionDao.save(promotion);
        assertEquals(promotion,promotionDao.get(promotion.getId()));
    }
}