package pl.maciek_rychlinski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.maciek_rychlinski.divider.NumberDivideValidator;
import pl.maciek_rychlinski.model.NumberBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;

@SpringBootApplication
public class SpringValidatorMessagesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringValidatorMessagesApplication.class, args);

        Locale.setDefault(Locale.ENGLISH);
        Validator validator=ctx.getBean(Validator.class);
        NumberBean numberBean=new NumberBean(1);
        Set<ConstraintViolation<NumberBean>> errore=validator.validate(numberBean);
        errore.forEach(err->System.out.println(err.getMessage()));
        ctx.close();
    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}


