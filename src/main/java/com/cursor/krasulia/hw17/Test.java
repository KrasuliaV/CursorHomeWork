package com.cursor.krasulia.hw17;

import com.cursor.krasulia.hw17.dao.AuthorDao;
import com.cursor.krasulia.hw17.dao.BookDao;
import com.cursor.krasulia.hw17.dao.UserDao;
import com.cursor.krasulia.hw17.entity.Author;
import com.cursor.krasulia.hw17.entity.Book;
import com.cursor.krasulia.hw17.entity.User;
import com.cursor.krasulia.hw17.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan(basePackages = {"com.cursor.krasulia.hw17"})
public class Test {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        final BookDao bookDao = context.getBean(BookDao.class);
        final AuthorDao authorDao = context.getBean(AuthorDao.class);
        final UserDao userDao = context.getBean(UserDao.class);

        addingEntitiesToTable(bookDao, authorDao, userDao);

        final Service service = context.getBean(Service.class);
        System.out.printf("All authors:%n%s%n", service.getAllAuthor());
        System.out.printf("All books:%n%s%n", service.getAllBook());
        System.out.printf("All books for one user %s:%n%s%n", service.getUserById(3L), service.getAllBooksForOneUser(3L));
        final User brian = service.getUserById(2L);
        final Book bookById = service.getBookById(1L);
        service.addBookToUser(brian, bookById);
    }

    private static void addingEntitiesToTable(BookDao bookDao, AuthorDao authorDao, UserDao userDao) {
        addAuthorToTable(authorDao);
        addBooksToTable(bookDao, authorDao);
        addUsersToTable(bookDao, userDao);
    }

    private static void addUsersToTable(BookDao bookDao, UserDao userDao) {
        final Book head_first_java = bookDao.findById(1L);
        final Book java_concurrency_in_practice = bookDao.findById(2L);
        final Book object_oriented_system_development = bookDao.findById(3L);
        final Book java_puzzlers = bookDao.findById(4L);

        final User dominic_toretto = new User("Dominic Toretto");
        dominic_toretto.setBooks(List.of(head_first_java, object_oriented_system_development));
        final User brian_o_conner = new User("Brian O’Conner");
        brian_o_conner.setBooks(List.of(java_concurrency_in_practice));
        final User letty_ortiz = new User("Letty Ortiz");
        letty_ortiz.setBooks(List.of(head_first_java, java_concurrency_in_practice, java_puzzlers, object_oriented_system_development));

        userDao.create(dominic_toretto);
        final Long brianId = userDao.create(brian_o_conner);

        userDao.create(letty_ortiz);
    }

    private static void addAuthorToTable(AuthorDao authorDao) {
        authorDao.create(new Author("Kathy Sierra"));
        authorDao.create(new Author("Bert Bates"));
        authorDao.create(new Author("Doug Lea"));
        authorDao.create(new Author("Joshua Bloch"));
    }

    private static void addBooksToTable(BookDao bookDao, AuthorDao authorDao) {
        final Author kathy_Sierr = authorDao.findById(1L);
        final Author bert_Bates = authorDao.findById(2L);
        final Author doug_Lea = authorDao.findById(3L);
        final Author joshua_Bloch = authorDao.findById(4L);
        final Book head_first_java = new Book("Head First Java");
        head_first_java.setAuthors(List.of(kathy_Sierr, bert_Bates));
        final Book java_concurrency_in_practice = new Book("Java Concurrency in Practice");
        java_concurrency_in_practice.setAuthors(List.of(joshua_Bloch, doug_Lea));
        final Book object_oriented_system_development = new Book("bject Oriented System Development");
        object_oriented_system_development.setAuthors(List.of(doug_Lea));
        final Book java_puzzlers = new Book("Java Puzzlers");
        java_puzzlers.setAuthors(List.of(joshua_Bloch));
        bookDao.create(head_first_java);
        bookDao.create(java_concurrency_in_practice);
        bookDao.create(object_oriented_system_development);
        bookDao.create(java_puzzlers);
    }
}
