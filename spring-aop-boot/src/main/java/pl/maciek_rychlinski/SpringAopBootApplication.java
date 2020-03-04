package pl.maciek_rychlinski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.maciek_rychlinski.model.Book;
import pl.maciek_rychlinski.service.BookRepository;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAopBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx=
        SpringApplication.run(SpringAopBootApplication.class, args);

        BookRepository repo = ctx.getBean(BookRepository.class);
        repo.add(new Book("1234567890123","Firs title","First Author"));
        repo.add(new Book("2345678901234","Second title","Second Author"));
        repo.add(new Book("3456789012345","Third title","Third Author"));

        Book book=repo.get("1234567890123");
        System.out.println(book);

        ctx.close();
    }

}
