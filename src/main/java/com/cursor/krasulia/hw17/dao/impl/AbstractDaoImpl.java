package com.cursor.krasulia.hw17.dao.impl;

import com.cursor.krasulia.hw17.dao.AbstractDao;
import com.cursor.krasulia.hw17.entity.AbstractEntity;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AbstractDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {

    protected Class<T> entityClass;

    protected final SessionFactory sessionFactory;

    public AbstractDaoImpl(SessionFactory sessionFactory, Class<T> entityClass) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }

    @Override
    @Transactional
    public Long create(T t) {
        return (Long) sessionFactory.getCurrentSession().save(t);
    }

    @Override
    @Transactional
    public T findById(Long id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    @Transactional
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    @Transactional
    public List<T> getAll() {
        final String query = "from %s".formatted(entityClass.getSimpleName());
        return sessionFactory.getCurrentSession().createQuery(query, entityClass).list();
    }
}
