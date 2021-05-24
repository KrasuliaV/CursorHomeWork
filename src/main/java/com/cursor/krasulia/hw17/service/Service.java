package com.cursor.krasulia.hw17.service;

import com.cursor.krasulia.hw17.dao.AuthorDao;
import com.cursor.krasulia.hw17.dao.BookDao;
import com.cursor.krasulia.hw17.dao.UserDao;
import com.cursor.krasulia.hw17.entity.Author;
import com.cursor.krasulia.hw17.entity.Book;
import com.cursor.krasulia.hw17.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private AuthorDao authorDao;
    private BookDao bookDao;
    private UserDao userDao;

    @Autowired
    public Service(AuthorDao authorDao, BookDao bookDao, UserDao userDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    public Book getBookById(Long id) {
        return Optional.ofNullable(bookDao.findById(id)).orElse(new Book());
    }

    public Author getAuthorById(Long id) {
        return Optional.ofNullable(authorDao.findById(id)).orElse(new Author());
    }

    public User getUserById(Long id) {
        return Optional.ofNullable(userDao.findById(id)).orElse(new User());
    }

    public List<Author> getAllAuthor() {
        return authorDao.getAll();
    }

    public List<Book> getAllBook() {
        return bookDao.getAll();
    }

    public void addBookToUser(User user, Book book) {
        final List<Book> usersBookByUserId = bookDao.getUsersBookByUserId(user.getId());
        usersBookByUserId.add(book);
        user.setBooks(usersBookByUserId);
        userDao.update(user);
    }

    public List<Book> getAllBooksForOneUser(Long id) {
        return bookDao.getUsersBookByUserId(id);
    }

}
