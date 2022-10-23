package entity;

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
    @OneToMany(mappedBy = "marketByMarketId")
    private Collection<MarketAdmin> marketAdminsById;

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

    public Collection<MarketAdmin> getMarketAdminsById() {
        return marketAdminsById;
    }

    public void setMarketAdminsById(Collection<MarketAdmin> marketAdminsById) {
        this.marketAdminsById = marketAdminsById;
    }
}
