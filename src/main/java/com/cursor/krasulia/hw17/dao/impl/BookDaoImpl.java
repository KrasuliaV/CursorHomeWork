package com.cursor.krasulia.hw17.dao.impl;

import com.cursor.krasulia.hw17.dao.BookDao;
import com.cursor.krasulia.hw17.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDaoImpl extends AbstractDaoImpl<Book> implements BookDao {

    @Autowired
    public BookDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Book.class);
    }

    @Override
    @Transactional
    public List<Book> getUsersBookByUserId(Long id) {
        final String s = "select b from User u " +
                "join u.books b " +
                "where u.id =:id";
        return sessionFactory.getCurrentSession().createQuery(s, Book.class).setParameter("id", id).list();
    }

}
