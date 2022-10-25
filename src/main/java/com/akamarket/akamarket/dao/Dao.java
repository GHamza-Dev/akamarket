package com.akamarket.akamarket.dao;

import java.util.List;

public interface Dao<D> {
    D get(int  id);

    List<D> getAll();

    void save(D d);

    void update(D d,String[] params);

    void delete(D d);
}
