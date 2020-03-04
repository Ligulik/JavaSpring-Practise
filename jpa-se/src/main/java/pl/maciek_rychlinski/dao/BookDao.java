package pl.maciek_rychlinski.dao;

import pl.maciek_rychlinski.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(long id);
    public void cleanUp();
}
