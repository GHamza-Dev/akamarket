package com.akamarket.akamarket.controller;

import com.akamarket.akamarket.dao.DeptManagerDao;
import com.akamarket.akamarket.dao.PromotionDao;
import com.akamarket.akamarket.entity.Category;
import com.akamarket.akamarket.entity.DepartementManager;
import com.akamarket.akamarket.entity.MarketAdmin;
import com.akamarket.akamarket.entity.Promotion;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionController {

    public void setToNotTreated(DepartementManager deptManager){
        int categoryId = deptManager.getCategory().getId();
        int marketAdminId = deptManager.getMarket().getMarketAdmin().getId();
        new PromotionDao().setStatusToNotTreated(categoryId,marketAdminId);
    }
    public List<Promotion> getDeptManagerPromotions(DepartementManager deptManager){
        int deptManagerId = deptManager.getId();
        MarketAdmin marketAdmin = new DeptManagerDao().get(deptManagerId).getMarket().getMarketAdmin();


        List<Promotion> promotions = marketAdmin.getPromotions().stream().filter(
                p -> LocalDate.parse(p.getAvUntile().toString()).isAfter(LocalDate.now())
        ).filter(
                p -> p.getCategory().getId() == deptManager.getCategory().getId()
        ).collect(Collectors.toList());

        return promotions;
    }
    public void addPromotion(MarketAdmin marketAdmin,int catId, Double percentage, Date avUntil){
        Promotion promotion = new Promotion();

        Category category = new Category();
        category.setId(catId);

        promotion.setMarketAdmin(marketAdmin);
        promotion.setPercentage(percentage);
        promotion.setLoyaltyPts(this.calculateLoyaltyPts(percentage));
        promotion.setAvUntile(avUntil);
        promotion.setCategory(category);
        promotion.setStatus("pending");

        new PromotionDao().save(promotion);
    }

    private Integer calculateLoyaltyPts(Double percentage){
        return (int)((percentage*50)/5);
    }
}
