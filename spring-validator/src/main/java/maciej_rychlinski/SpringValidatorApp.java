package maciej_rychlinski;

import maciej_rychlinski.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import maciej_rychlinski.service.PersonService;

@Configuration
@ComponentScan
public class SpringValidatorApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringValidatorApp.class);

        PersonService personService=ctx.getBean(PersonService.class);
        Person person1=new Person("Maciek","Rychlinski","mac@wp.pl",0);
        personService.addPerson(person1);

        Person person2=new Person("Agata","aaa",null,12);
        personService.addPerson(person2);

        Person person3=new Person("Staszek","Nowak","wwwwow@ww.pl",2);
        personService.addPerson(person3);

        System.out.println("Persons  " +personService.getPeople().size());
        for(Person p:personService.getPeople()){
            System.out.println(p);
        }

        ctx.close();
    }

}
