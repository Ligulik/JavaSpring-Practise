package maciej_rychlinski.service;


import maciej_rychlinski.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import maciej_rychlinski.validator.PersonValidator;

import java.util.HashSet;
import java.util.Set;

@Service
@PropertySource("classpath:error_messages.properties")
public class PersonService {

    private Set<Person> people;
    private Validator validator;

    @Autowired
    private Environment env;

    @Autowired
    public PersonService(Validator validator){
        this.validator=validator;
        people=new HashSet<Person>();
    }


    public void addPerson(Person person){
        Errors errors= new BeanPropertyBindingResult(person,"person");
        validator.validate(person,errors);
        if(errors.hasErrors()){
            System.out.println("Ilość błędów:" + errors.getErrorCount());
            for(ObjectError error:errors.getAllErrors()){
                System.out.println(env.getProperty(error.getCode()));
            }
        }else {
            people.add(person);
        }

    }

    public Set<Person> getPeople(){
        return this.people;
    }

}
