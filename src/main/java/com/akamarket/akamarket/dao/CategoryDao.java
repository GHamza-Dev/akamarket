package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.entity.Category;
import com.akamarket.akamarket.helper.JPA;
import jakarta.persistence.Query;

import java.util.List;
import java.util.function.Consumer;

public class CategoryDao implements Dao<Category> {
    @Override
    public Category get(int id){
        Category category = JPA.entityManager().find(Category.class,id);
        return category;
    }

    @Override
    public List<Category> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }

    @Override
    public void save(Category category) {
        JPA.wrap(em -> em.persist(category));
    }

    @Override
    public void update(Category category, String[] params) {

    }

    public void update(Category category,Consumer<Category>[] setters) {
        for (int i = 0; i < setters.length; i++) {
            setters[i].accept(category);
        }
        JPA.wrap(entityManager -> entityManager.merge(category));
    }

    @Override
    public void delete(Category category) {
        JPA.wrap(entityManager -> entityManager.remove(category));
    }
}
