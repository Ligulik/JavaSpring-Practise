package pl.maciekrychlinski.beans.decorators;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.maciekrychlinski.beans.decorators.MessageDecorator;
import pl.maciekrychlinski.beans.producers.Producer;

@Component
@Producer(type= Producer.ProducerType.UPPER)
public class UpperCaseMessageDecorator implements MessageDecorator {
    @Override
    public String decorate(String msg) {
        return msg.toUpperCase();
    }
}
