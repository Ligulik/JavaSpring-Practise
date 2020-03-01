package pl.maciekrychlinski.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.maciekrychlinski.beans.MessagePrinter;

public class SpringDiAplication {
    public static void main(String[] arg){
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans-config.xml");
        MessagePrinter messagePrinter=ctx.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
        ctx.close();
    }
}
