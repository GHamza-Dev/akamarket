package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.entity.MarketAdmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatableTest {

    @Test
    void authenticatableExistTest() {
        assertEquals(Authenticatable.exist("mkt_admin@gmail.com","1234", MarketAdmin.class).getEmail(),"mkt_admin@gmail.com");
    }

    @Test
    void authenticatableDoesNotExistTest() {
        assertNull(Authenticatable.exist("what-ever-user-email@gmail.com","1234", MarketAdmin.class));
    }
}