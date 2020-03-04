package pl.maciek_rychlinski;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.maciek_rychlinski.beans.MessagePrinter;
import pl.maciek_rychlinski.beans.MessageProducer;

@Configuration
@ComponentScan

public class SpringDiAplication {
    public static void main(String[] arg){
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringDiAplication.class);

        MessagePrinter bean1=ctx.getBean(MessagePrinter.class);
        bean1.printMessage();
        MessagePrinter bean2=ctx.getBean(MessagePrinter.class);
        bean1.printMessage();
    }
}
