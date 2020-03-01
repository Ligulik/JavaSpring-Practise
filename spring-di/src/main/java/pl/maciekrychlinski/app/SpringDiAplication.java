package pl.maciekrychlinski.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.maciekrychlinski.beans.printers.MessagePrinter;

@Configuration
@ComponentScan(basePackages = "pl.maciekrychlinski")

public class SpringDiAplication {
    public static void main(String[] arg){
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(SpringDiAplication.class);
        MessagePrinter printer=ctx.getBean(MessagePrinter.class);
        printer.printMessage();
        ctx.close();
    }
}
