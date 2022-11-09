package com.akamarket.akamarket.controller;

import com.akamarket.akamarket.dao.MarketDao;
import com.akamarket.akamarket.entity.Market;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketController {

    public static List<Market> getMarketsWithNoAdmin(){
        return new MarketDao().getAll()
                .stream()
                .filter(market -> market.getMarketAdmin() == null)
                .collect(Collectors.toList());
    }
    public static void addMarket(String city,String address){

        Market market = new Market();
        market.setCity(city);
        market.setAddress(address);

        MarketDao marketDao = new MarketDao();
        marketDao.save(market);
    }
}
