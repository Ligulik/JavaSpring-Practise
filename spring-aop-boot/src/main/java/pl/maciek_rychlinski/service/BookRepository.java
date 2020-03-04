package pl.maciek_rychlinski.service;

import org.springframework.stereotype.Component;
import pl.maciek_rychlinski.model.Book;

import java.util.LinkedList;
import java.util.List;


@Component
public class BookRepository implements GenericRepository<String, Book> {

    private List<Book> books;

    public BookRepository(){
        books=new LinkedList<>();
    }

    @Override
    public Book get(String isbm) {
        if(isbm==null||isbm.length()!=13)
            throw new IllegalArgumentException("You haveto provide invalid ISBM number");
        Book find=books.stream()
                .filter(b->isbm.equals(b.getIsbm()))
                .findFirst()
                .get();
        randomPause(300);
        return find;

    }

    @Override
    public void add(Book book) {
        if(book==null||book.getAuthor()==null||book.getTitle()==null||book.getIsbm()==null)
            throw new IllegalArgumentException("Book cannot have null fields");
        randomPause(1000);
        books.add(book);
    }

    private void randomPause(int maxTime){
        try{
            Thread.sleep(maxTime);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
