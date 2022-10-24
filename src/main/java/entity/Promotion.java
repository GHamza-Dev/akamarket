package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "percentage", nullable = true, precision = 0)
    private Double percentage;
    @Basic
    @Column(name = "loyalty_pts", nullable = true)
    private Integer loyaltyPts;
    @Basic
    @Column(name = "status", nullable = true, length = 30)
    private String status;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Date createdAt;
    @Basic
    @Column(name = "av_untile", nullable = true)
    private Date avUntile;
    @Basic
    @Column(name = "deptmanagercomment", nullable = true, length = 50)
    private String deptmanagercomment;
    @ManyToOne
    @JoinColumn(name = "market_admin", referencedColumnName = "id")
    private MarketAdmin marketAdmin;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Integer getLoyaltyPts() {
        return loyaltyPts;
    }

    public void setLoyaltyPts(Integer loyaltyPts) {
        this.loyaltyPts = loyaltyPts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getAvUntile() {
        return avUntile;
    }

    public void setAvUntile(Date avUntile) {
        this.avUntile = avUntile;
    }

    public String getDeptmanagercomment() {
        return deptmanagercomment;
    }

    public void setDeptmanagercomment(String deptmanagercomment) {
        this.deptmanagercomment = deptmanagercomment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (id != promotion.id) return false;
        if (percentage != null ? !percentage.equals(promotion.percentage) : promotion.percentage != null) return false;
        if (loyaltyPts != null ? !loyaltyPts.equals(promotion.loyaltyPts) : promotion.loyaltyPts != null) return false;
        if (status != null ? !status.equals(promotion.status) : promotion.status != null) return false;
        if (createdAt != null ? !createdAt.equals(promotion.createdAt) : promotion.createdAt != null) return false;
        if (avUntile != null ? !avUntile.equals(promotion.avUntile) : promotion.avUntile != null) return false;
        if (deptmanagercomment != null ? !deptmanagercomment.equals(promotion.deptmanagercomment) : promotion.deptmanagercomment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + (loyaltyPts != null ? loyaltyPts.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (avUntile != null ? avUntile.hashCode() : 0);
        result = 31 * result + (deptmanagercomment != null ? deptmanagercomment.hashCode() : 0);
        return result;
    }

    public MarketAdmin getMarketAdmin() {
        return marketAdmin;
    }

    public void setMarketAdmin(MarketAdmin marketAdminByMarketAdmin) {
        this.marketAdmin = marketAdminByMarketAdmin;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryByCategoryId) {
        this.category = categoryByCategoryId;
    }
}
