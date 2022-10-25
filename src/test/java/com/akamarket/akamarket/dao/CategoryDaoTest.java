package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.entity.Category;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDaoTest {

    @Test
    void get() {
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category();
        category.setCategoryName("Clothes");
        category.setId(1);
        Category category1 = categoryDao.get(1);
        assertEquals(category1,category);
    }

    @Test
    void getAll() {
        List<Category> categories = new CategoryDao().getAll();
        List<Category> matchCategories = new ArrayList<>();

        Category cat1 = new Category();
        Category cat2 = new Category();

        cat1.setId(1);
        cat1.setCategoryName("Clothes");

        cat2.setId(2);
        cat2.setCategoryName("Electronic");

        matchCategories.add(cat1);
        matchCategories.add(cat2);

        assertEquals(categories.getClass(),matchCategories.getClass());
        assertEquals(categories,matchCategories);
    }

    @Test
    void save() {
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category();
        category.setCategoryName("Fruits");
        categoryDao.save(category);
        assertEquals(categoryDao.get(category.getId()),category);
    }

    @Test
    void update() {
        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.get(1);
        Consumer<Category>[] setters = new Consumer[1];
        setters[0] = cat -> cat.setCategoryName("Hamza");
        categoryDao.update(category,setters);
        assertEquals(category,categoryDao.get(1));
    }

    @Test
    void delete() {
        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.get(5);
        if (category != null) {
            categoryDao.delete(category);
            assertNull(categoryDao.get(1));
        }
    }
}