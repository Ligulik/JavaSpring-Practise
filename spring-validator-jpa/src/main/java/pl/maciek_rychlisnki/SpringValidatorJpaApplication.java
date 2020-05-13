package pl.maciek_rychlisnki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringValidatorJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorJpaApplication.class, args);

        // Dodanie osoby z nieprawidłowo wypełnionymi polami:

        PersonService personService = ctx.getBean(PersonService.class);
        Person badPerson = new Person("Maciek", "", "stasze.wp.pl", 2);
        personService.add(badPerson);

        // Dodanie osoby z prawidłowo wypełnionymi polami:

        Person goodPerson = new Person("Agata", "Bartnikowska", "agata@wp.pl", 21);
        personService.add(goodPerson);

        ctx.close();
    }

}
