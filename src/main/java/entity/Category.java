package entity;

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
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<DepartementManager> departementManagersById;
    @OneToMany(mappedBy = "categoryBySubCatId")
    private Collection<Promotion> promotionsById;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<Subcategory> subcategoriesById;

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

    public Collection<DepartementManager> getDepartementManagersById() {
        return departementManagersById;
    }

    public void setDepartementManagersById(Collection<DepartementManager> departementManagersById) {
        this.departementManagersById = departementManagersById;
    }

    public Collection<Promotion> getPromotionsById() {
        return promotionsById;
    }

    public void setPromotionsById(Collection<Promotion> promotionsById) {
        this.promotionsById = promotionsById;
    }

    public Collection<Subcategory> getSubcategoriesById() {
        return subcategoriesById;
    }

    public void setSubcategoriesById(Collection<Subcategory> subcategoriesById) {
        this.subcategoriesById = subcategoriesById;
    }
}
