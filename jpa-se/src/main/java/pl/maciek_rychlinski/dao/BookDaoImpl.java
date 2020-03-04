package pl.maciek_rychlinski.dao;

import pl.maciek_rychlinski.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDaoImpl implements BookDao {
    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public BookDaoImpl(){
        emFactory= Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager=emFactory.createEntityManager();
    }


    public void save(Book book) {
        EntityTransaction tx=entityManager.getTransaction();
        tx.begin();
        entityManager.persist(book);
        tx.commit();
    }

    public Book get(long id) {
        Book book=entityManager.find(Book.class,id);
        return book;
    }

    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }
}
