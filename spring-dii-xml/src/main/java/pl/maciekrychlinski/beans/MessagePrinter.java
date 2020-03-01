package pl.maciekrychlinski.beans;

public class MessagePrinter {
    private MessageProducer messageProducer;

    public MessagePrinter() {
    }

    public MessageProducer getMessageProducer() {
        return messageProducer;
    }

    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public MessagePrinter(MessageProducer messageProducer){
        this.messageProducer=messageProducer;
    }

    public void printMessage(){
        String printedMessage=messageProducer.getMessage();
        System.out.println(printedMessage);
    }

}
