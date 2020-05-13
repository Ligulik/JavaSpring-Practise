package pl.maciek_rychlisnki;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;


/**
 * Klase personService tworze, aby uzyskać wyższą warstwę abstrakcji i obsłużyć wyjątek ConstraintViolentException
 * <p>
 * Pamiętam o dodaniu repozytorium przez autowiązanie
 */


@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void add(Person person) {
        try {
            personRepository.add(person);
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> erros = e.getConstraintViolations();
            erros.forEach(err -> System.err.println(
                    err.getPropertyPath() + " " +
                            err.getInvalidValue() + " " +
                            err.getMessage()));
        }
    }
}
