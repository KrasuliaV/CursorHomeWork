package com.cursor.krasulia.hw17.dao.impl;

import com.cursor.krasulia.hw17.dao.UserDao;
import com.cursor.krasulia.hw17.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

}
