package com.akamarket.akamarket.controller;

import com.akamarket.akamarket.dao.MarketAdminDao;
import com.akamarket.akamarket.entity.Market;
import com.akamarket.akamarket.entity.MarketAdmin;
import com.akamarket.akamarket.helper.Mail;

public class MarketAdminController {

    public static void addMarketAdmin(String username,String email,int marketId){
        MarketAdmin marketAdmin = new MarketAdmin();
        Market market = new Market();
        market.setId(marketId);

        marketAdmin.setUsername(username);
        marketAdmin.setEmail(email);
        marketAdmin.setPassword("1234");

        marketAdmin.setMarket(market);

        new MarketAdminDao().save(marketAdmin);

        String message = "<p>You have been added as a market admin of marjane</p>" +
                "<p>Your password is: 1234</p>" +
                "Please go to: http://localhost:8080/akaMarket_war_exploded/index.jsp to change your password.";

        Mail.send("gassai.hamza@gmail.com","Test",message);
    }
}
