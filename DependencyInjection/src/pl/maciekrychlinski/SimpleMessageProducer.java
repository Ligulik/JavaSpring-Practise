package pl.maciekrychlinski;

public class SimpleMessageProducer implements MessageProducer {

    @Override
    public String getMessage() {
        return "Example Message" +System.currentTimeMillis();
    }
}
