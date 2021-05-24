package com.cursor.krasulia.hw17.dao.impl;

import com.cursor.krasulia.hw17.dao.AuthorDao;
import com.cursor.krasulia.hw17.entity.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl extends AbstractDaoImpl<Author> implements AuthorDao {

    @Autowired
    public AuthorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Author.class);
    }

}
