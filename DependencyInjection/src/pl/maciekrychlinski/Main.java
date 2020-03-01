package pl.maciekrychlinski;

public class Main {
    public static void main(String[] arg){
        MessageProducer messageProducer=new SimpleMessageProducer();
        MessagePrinter messagePrinter=new MessagePrinter(messageProducer);
        messagePrinter.printMessage();

        MessageProducer messageProducer1=new FileMessageProducer();
        MessagePrinter messagePrinter1=new MessagePrinter(messageProducer1);
        messagePrinter1.printMessage();

    }
}
