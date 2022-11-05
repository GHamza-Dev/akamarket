package com.akamarket.akamarket.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Market {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "city", nullable = true, length = 50)
    private String city;

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    private String address;
    @OneToOne(mappedBy = "market")
    private MarketAdmin marketAdmin;

    @OneToMany(mappedBy = "market")
    private Collection<DepartementManager> departementManagers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Market market = (Market) o;

        if (id != market.id) return false;
        if (city != null ? !city.equals(market.city) : market.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<DepartementManager> getDepartementManagers() {
        return departementManagers;
    }

    public void setDepartementManagers(Collection<DepartementManager> departementManagers) {
        this.departementManagers = departementManagers;
    }

    public MarketAdmin getMarketAdmin() {
        return marketAdmin;
    }

    public void setMarketAdmin(MarketAdmin marketAdmin) {
        this.marketAdmin = marketAdmin;
    }
}
