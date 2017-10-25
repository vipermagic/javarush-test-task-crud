package net.vipermagi.javarushcrud.dao;

import net.vipermagi.javarushcrud.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book added. Book details: " + book);
    }

    public void updateBook(Book book) {
//        Session session = sessionFactory.getCurrentSession();

        //Бизнес-требование: при редактировании может быть 2 варианта поведение:

        //1. Книгу прочитали, и тогда изменяется только поле readAlready, и только, если оно
        //   было false. Значения поля должно стать true.
        Book oldBook = getBookById(book.getId());
        if(oldBook.isReadAlready() == false && book.isReadAlready() == true) {
            oldBook.setReadAlready(true);
        }

        //2. Книгу заменили на новое издание. В этом случае должна быть возможность
        //   изменить title, description, isbn, printYear. А поле readAlready нужно выставить в
        //   false. Поле author должно быть неизменяемым с момента создания книги.
        if(!oldBook.getIsbn().equals(book.getIsbn())) {
            oldBook.setReadAlready(false);
            oldBook.setTitle(book.getTitle());
            oldBook.setDescription(book.getDescription());
            oldBook.setIsbn(book.getIsbn());
            oldBook.setPrintYear(book.getPrintYear());
        }

//        session.update(book);
        logger.info("Book updated. Book details: " + book);
    }

    public void removeBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        if(book != null) {
            session.delete(book);
        }
        logger.info("Book removed. Book details: " + book);
    }

    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book loaded. Book details: " + book);
        return book;
    }

    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        for(Book book : bookList) {
            logger.info("Book list: " + book);
        }

        return bookList;
    }
}
