package pl.maciek_rychlinski.model;

public class Book {
    private String isbm;
    private String title;
    private String author;

    public Book(String isbm, String title, String author) {
        this.isbm = isbm;
        this.title = title;
        this.author = author;
    }

    public String getIsbm() {
        return isbm;
    }

    public void setIsbm(String isbm) {
        this.isbm = isbm;
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
                "isbm='" + isbm + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
