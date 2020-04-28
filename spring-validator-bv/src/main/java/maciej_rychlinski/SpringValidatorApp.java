package maciej_rychlinski;


import maciej_rychlinski.model.Person;
import maciej_rychlinski.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@Configuration
@ComponentScan
public class SpringValidatorApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringValidatorApp.class);

        PersonService personService=ctx.getBean(PersonService.class);
        Person person1=new Person("Maciej","Rychliński","rysiu220398@gmail.com",21);
        System.out.println("Adding" +person1);
        personService.addPerson(person1);

        Person person2=new Person("Agata", null, "email",20);
        System.out.println("Adding" + person2);
        personService.addPerson(person2);

        Person person3=new Person("Staszek", "Nowak","Staszek@wp.pl",0);
        System.out.println("Adding" + person3);
        personService.addPerson(person3);

        ctx.close();
    }


    // Tworze obiekt Validator, ktory zostanie wstrzyknięty autowiązanime do PersonService
@Bean

    public Validator validator(){
        return new LocalValidatorFactoryBean();
}
}
