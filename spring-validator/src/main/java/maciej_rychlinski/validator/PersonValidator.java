package maciej_rychlinski.validator;


import maciej_rychlinski.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {


    private final static int MIN_AGE=1;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person=(Person) target;
        checkEmail(person,errors);
        checkAge(person,errors);
    }


    public void checkEmail(Person person, Errors errors){
        if(person.getEmail()==null){
            errors.rejectValue("email","required");
        }else if(!person.getEmail().contains("@")){
            errors.rejectValue("email","invalid");
        }
    }


    public void checkAge(Person person, Errors errors){
        if(person.getAge()<PersonValidator.MIN_AGE){
            errors.rejectValue("age","invalid");
        }
    }
}
