package pl.maciek_rychlinski;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.maciek_rychlinski.model.Book;
import pl.maciek_rychlinski.service.BookRepository;
import pl.maciek_rychlinski.service.GenericRepository;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringDiApplication.class);

        BookRepository repo = ctx.getBean(BookRepository.class);
        repo.add(new Book("1234567890123","Firs title","First Author"));
        repo.add(new Book("2345678901234","Second title","Second Author"));
        repo.add(new Book("3456789012345","Third title","Third Author"));

        Book book=repo.get("1234567890123");
        System.out.println(book);

        ctx.close();
    }
}
