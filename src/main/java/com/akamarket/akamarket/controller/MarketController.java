package com.akamarket.akamarket.controller;

import com.akamarket.akamarket.dao.MarketDao;
import com.akamarket.akamarket.entity.Market;

public class MarketController {
    public static void addMarket(String city,String address){

        Market market = new Market();
        market.setCity(city);
        market.setAddress(address);

        MarketDao marketDao = new MarketDao();
        marketDao.save(market);
    }
}
