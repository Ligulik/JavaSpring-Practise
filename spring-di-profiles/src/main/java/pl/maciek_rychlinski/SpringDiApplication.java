package pl.maciek_rychlinski;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.maciek_rychlinski.beans.NamesRepository;

import java.util.List;

@Configuration
@ComponentScan
public class SpringDiApplication {
    public static void main(String[] arg){

        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringDiApplication.class);

        NamesRepository namesRepository=ctx.getBean(NamesRepository.class);
        List<String> allNames=namesRepository.getAll();
        allNames.forEach(System.out::println);

        ctx.close();
    }

}
