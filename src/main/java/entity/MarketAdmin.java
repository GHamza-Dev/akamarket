package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "market_admin", schema = "public", catalog = "akamarket")
public class MarketAdmin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @OneToOne
    @JoinColumn(name = "market_id", referencedColumnName = "id")
    private Market market;
    @OneToMany(mappedBy = "marketAdmin")
    private Collection<Promotion> promotions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarketAdmin that = (MarketAdmin) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Market getMarketByMarketId() {
        return market;
    }

    public void setMarketByMarketId(Market market) {
        this.market = market;
    }

    public Collection<Promotion> getPromotionsById() {
        return promotions;
    }

    public void setPromotionsById(Collection<Promotion> promotions) {
        this.promotions = promotions;
    }
}
