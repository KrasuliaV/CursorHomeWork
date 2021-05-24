package com.cursor.krasulia.hw17.dao;

import com.cursor.krasulia.hw17.entity.AbstractEntity;

import java.util.List;

public interface AbstractDao<T extends AbstractEntity> {
    Long create(T t);

    T findById(Long id);

    void update(T t);

    void delete(T t);

    List<T> getAll();

}
