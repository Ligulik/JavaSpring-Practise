package pl.maciekrychlinski.beans.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.URIParameter;
import java.util.List;


@Component
@Producer(type= Producer.ProducerType.FILE)
public class FileMessageProducer implements MessageProducer {


    @Autowired
    @Value("${messageFileProperty}")
    private String messageFile;

    @Override
    public String getMessage() {
        List<String> lines=null;
        try{
            Path path = new File(getClass().getResource(messageFile).toURI()).toPath();
            lines= Files.readAllLines(path);
        }catch (IOException | URISyntaxException e){
            System.out.println(e.getMessage());
        }

    String result="";
        if(lines!=null)
            result=lines.stream().reduce(result,(a,b)->a+b);
            return result;


    }
}
