package pl.maciek_rychlinski.dao;

import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.model.Book;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
public class BookDaoImpl implements BookDao {

@PersistenceContext
private EntityManager entityManager;

BookDaoImpl(){

}
    @Override
    @Transactional
    public void save(Book book) {
    entityManager.persist(book);

    }

    @Override
    public Book load(long isbn) {
        Book book=entityManager.find(Book.class,isbn);
        return book;
    }

    @Transactional
    @Override
    public void update(Book book) {
        Book find=entityManager.find(Book.class,book.getId());
        if(find!=null){
            find.setTitle(book.getTitle());
            find.setIsbn(book.getIsbn());
            find.setAuthor(book.getAuthor());
        }
    }

    @Transactional
    @Override
    public void delete(long bookId) {
        Book objToRemove=entityManager.find(Book.class,bookId);
        entityManager.remove(objToRemove);
        System.out.println(objToRemove.getId());
    }
}
