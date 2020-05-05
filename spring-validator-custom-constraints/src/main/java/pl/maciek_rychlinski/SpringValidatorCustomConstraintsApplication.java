package pl.maciek_rychlinski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.maciek_rychlinski.model.Message;
import pl.maciek_rychlinski.service.MessageService;

import javax.validation.Validator;

@SpringBootApplication
public class SpringValidatorCustomConstraintsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringValidatorCustomConstraintsApplication.class, args);
        MessageService messageService=ctx.getBean(MessageService.class);
        Message message=new Message("tytuł","fak");
        boolean zawiera=messageService.verifyMessage(message);
        System.out.println("Czy to zdanie jest poprawne ?"+zawiera);

        ctx.close();
    }


    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}
