package pl.maciekrychlinski.beans.decorators;

import org.springframework.stereotype.Component;
import pl.maciekrychlinski.beans.producers.Producer;

@Component
@Producer(type= Producer.ProducerType.LOWER)
public class LowerCaseMessageDecorator implements MessageDecorator {

    @Override
    public String decorate(String msg) {
        return msg.toLowerCase();
    }
}
