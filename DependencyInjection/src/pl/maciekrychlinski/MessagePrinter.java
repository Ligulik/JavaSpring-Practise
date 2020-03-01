package pl.maciekrychlinski;

public class MessagePrinter {
    private MessageProducer messageProducer;

    public MessagePrinter(MessageProducer messageProducer){
        this.messageProducer=messageProducer;
    }

    public void printMessage(){
        String printedMessage=messageProducer.getMessage();
        System.out.println(printedMessage);
    }

}
