package pl.maciek_rychlinski.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maciek_rychlinski.Draft;
import pl.maciek_rychlinski.Full;
import pl.maciek_rychlinski.model.Project;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ProjectService {

    private Validator validator;

    @Autowired
    public ProjectService(Validator validator){
        this.validator=validator;
    }

    public boolean validateDraft(Project project){
        Set<ConstraintViolation<Project>> errors=validator.validate(project, Draft.class);
        errors.forEach(err->System.out.println(err.getMessage()));
        return errors.isEmpty()?true:false;
    }

    public boolean validateFull(Project project){
        Set<ConstraintViolation<Project>> errors=validator.validate(project, Full.class);
        errors.forEach(err->System.out.println(err.getMessage()));
        return errors.isEmpty()?true:false;
    }

}
