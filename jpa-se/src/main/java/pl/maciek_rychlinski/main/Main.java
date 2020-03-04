package pl.maciek_rychlinski.main;

import pl.maciek_rychlinski.dao.BookDao;
import pl.maciek_rychlinski.dao.BookDaoImpl;
import pl.maciek_rychlinski.model.Book;

public class Main {
    public static void main(String[] args) {
        Book book=new Book("1234567890123","Author1","Title1");
        BookDao bookDao=new BookDaoImpl();
        bookDao.save(book);
        Book book1=bookDao.get(1L);
        System.out.println(book1);
        bookDao.cleanUp();
    }
}
