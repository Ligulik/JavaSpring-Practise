package pl.maciekrychlinski.beans.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.maciekrychlinski.beans.decorators.MessageDecorator;
import pl.maciekrychlinski.beans.producers.MessageProducer;
import pl.maciekrychlinski.beans.producers.Producer;

@Component
public class MessagePrinter {

    private MessageProducer messageProducer;
    private MessageDecorator messageDecorator;

    public MessageDecorator getMessageDecorator() {
        return messageDecorator;
    }

    @Autowired(required = false)
    public void setMessageDecorator(@Producer(type= Producer.ProducerType.UPPER) MessageDecorator messageDecorator) {
        this.messageDecorator = messageDecorator;
    }

    public MessagePrinter() {
    }

    public MessageProducer getMessageProducer() {
        return messageProducer;
    }

    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @Autowired
    public MessagePrinter(@Producer(type = Producer.ProducerType.FILE)MessageProducer messageProducer){
        this.messageProducer=messageProducer;
    }

    public void printMessage(){
        String printedMessage=messageProducer.getMessage();
        printedMessage=messageDecorator!=null?messageDecorator.decorate(printedMessage):printedMessage;
        System.out.println(printedMessage);
    }

}
