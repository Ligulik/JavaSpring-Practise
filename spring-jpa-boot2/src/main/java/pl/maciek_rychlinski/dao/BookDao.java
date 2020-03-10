package pl.maciek_rychlinski.dao;

import pl.maciek_rychlinski.model.Book;

public interface BookDao {
    void save(Book book);
    Book load(long id);
    void update(Book book);
    void delete(long bookId);
}
