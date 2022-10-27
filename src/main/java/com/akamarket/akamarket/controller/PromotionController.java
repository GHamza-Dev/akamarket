package com.akamarket.akamarket.controller;

import com.akamarket.akamarket.dao.PromotionDao;
import com.akamarket.akamarket.entity.Category;
import com.akamarket.akamarket.entity.MarketAdmin;
import com.akamarket.akamarket.entity.Promotion;

import java.sql.Date;

public class PromotionController {
    public void addPromotion(MarketAdmin marketAdmin,int catId, Double percentage, int loyaltyPts, Date avUntil){
        Promotion promotion = new Promotion();

        Category category = new Category();
        category.setId(catId);

        promotion.setMarketAdmin(marketAdmin);
        promotion.setPercentage(percentage);
        promotion.setLoyaltyPts(loyaltyPts);
        promotion.setAvUntile(avUntil);
        promotion.setCategory(category);

        new PromotionDao().save(promotion);
    }
}
