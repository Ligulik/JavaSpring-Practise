package pl.maciek_rychlinski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.maciek_rychlinski.dao.BookDao;
import pl.maciek_rychlinski.dao.BookDaoImpl;
import pl.maciek_rychlinski.model.Book;

@SpringBootApplication
public class SpringJpaBoot2Application {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx=SpringApplication.run(SpringJpaBoot2Application.class, args);
        BookDao bookDao=ctx.getBean(BookDao.class);

        //Create:
        Book book=new Book("5555555555555","Zły tutuł","Słaby autor");
        bookDao.save(book);

        //Update
        Book book1=new Book("5555555555555","Dobry Tytuł","Dobry Autor");
        book1.setId(1L);
        bookDao.update(book1);

        //Read
        Book findBook=bookDao.load(1L);
        System.out.println(findBook);

        //Delete
        bookDao.delete(1L);
        Book book3=bookDao.load(1L);
        System.out.println(book3);
    }

}
