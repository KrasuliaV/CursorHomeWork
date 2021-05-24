package com.cursor.krasulia.hw17.dao;

import com.cursor.krasulia.hw17.entity.Book;

import java.util.List;

public interface BookDao extends AbstractDao<Book> {

    List<Book> getUsersBookByUserId(Long id);
}
