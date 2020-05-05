package pl.maciek_rychlinski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maciek_rychlinski.model.Message;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class MessageService {

    private javax.validation.Validator validator;

    @Autowired
    public MessageService(Validator validator){
        this.validator=validator;
    }

    public boolean verifyMessage(Message message){
        Set<ConstraintViolation<Message>> errors=validator.validate(message);
        if(!errors.isEmpty()){
            errors.forEach(err->System.out.println(err.getMessage()));
            return false;
        }else{
            return true;
        }
    }
}
