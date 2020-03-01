package pl.maciekrychlinski.beans;

public class SimpleMessageProducer implements MessageProducer {


    public String getMessage() {
        return "Example Message" +System.currentTimeMillis();
    }
}
