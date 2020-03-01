package pl.maciekrychlinski;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileMessageProducer implements MessageProducer {

    @Override
    public String getMessage() {
        List<String> lines=null;
        try{
            lines= Files.readAllLines(Paths.get("message.txt"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    String result="";
        if(lines!=null)
            result=lines.stream().reduce(result,(a,b)->a+b);
            return result;


    }
}
