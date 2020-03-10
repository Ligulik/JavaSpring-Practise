package pl.maciek_rychlinski.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    private final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    @Column(name="book_id")
    private Long id;
    @Column(nullable = false, length = 13,unique = true)
    private String isbn;
    @Column(nullable = false)
    private String title;
    @Column(nullable =false)
    private String author;

    public Book() {
    }

    public Book(String isbn, String title, String author){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    @PrePersist
    public void prePresist(){
        System.out.println("Zapis obiektu"+this);
    }

    @PostPersist
    public void postPersist(){
        System.out.println("Zapisano obiekt"+this);
    }

    @PostLoad
    public void postLoad(){
        System.out.println("Poprawnie wczytano dane");
    }
}
