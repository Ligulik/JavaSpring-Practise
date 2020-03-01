package pl.maciekrychlinski.beans.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.maciekrychlinski.beans.producers.MessageProducer;

@Component
@Producer(type = Producer.ProducerType.SIMPLE)
public class SimpleMessageProducer implements MessageProducer {

    @Autowired
    @Qualifier("randomNumber")
    private int randomNumber;

    public String getMessage() {
        return "Example Message" + " : "+randomNumber;
    }
}
