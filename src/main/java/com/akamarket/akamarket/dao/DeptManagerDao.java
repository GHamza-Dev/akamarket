package com.akamarket.akamarket.dao;

import com.akamarket.akamarket.entity.DepartementManager;
import com.akamarket.akamarket.helper.JPA;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class DeptManagerDao implements Dao<DepartementManager>{
    public DepartementManager get(int id){
        DepartementManager deptManager = JPA.entityManager().find(DepartementManager.class,id);
        return deptManager;
    }

    @Override
    public List<DepartementManager> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c FROM DepartementManager c");
        return query.getResultList();
    }

    @Override
    public void save(DepartementManager deptManager) {
        JPA.wrap(entityManager -> entityManager.persist(deptManager));
    }

    @Override
    public void update(DepartementManager deptManager, String[] params) {
        deptManager.setEmail(Objects.requireNonNull(params[0], "Email cannot be null"));
        deptManager.setUsername(Objects.requireNonNull(params[1], "Username cannot be null"));
        deptManager.setPassword(Objects.requireNonNull(params[2], "Password cannot be null"));
        JPA.wrap(entityManager -> entityManager.merge(deptManager));
    }

    public void update(DepartementManager deptManager, Consumer<DepartementManager>[] setters) {
        for (int i = 0; i < setters.length; i++) {
            setters[i].accept(deptManager);
        }
        JPA.wrap(entityManager -> entityManager.merge(deptManager));
    }

    @Override
    public void delete(DepartementManager deptManager) {
        JPA.wrap(entityManager -> entityManager.remove(deptManager));
    }
}
