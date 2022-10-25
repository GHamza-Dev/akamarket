package com.akamarket.akamarket.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "category_name", nullable = true, length = 50)
    private String categoryName;
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private Collection<Category> categories;
    @OneToOne(mappedBy = "category")
    private DepartementManager departementManager;
    @OneToMany(mappedBy = "category")
    private Collection<Promotion> promotions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category categoryByParentId) {
        this.parent = categoryByParentId;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categoriesById) {
        this.categories = categoriesById;
    }

    public DepartementManager getDepartementManagers() {
        return departementManager;
    }

    public void setDepartementManagers(DepartementManager departementManager) {
        this.departementManager = departementManager;
    }

    public Collection<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Collection<Promotion> promotionsById) {
        this.promotions = promotionsById;
    }
}
