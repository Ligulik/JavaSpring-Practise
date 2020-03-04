package pl.maciek_rychlinski.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.maciek_rychlinski.profiles.DevProfile;
import pl.maciek_rychlinski.profiles.ProdProfile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    @DevProfile
    public DatabaseDatesource getH2Datasource(){
        return(()-> Arrays.asList("MaciekTest","KrzysztofTest","JarekTest"));
    }

    @Bean
    @ProdProfile
    public DatabaseDatesource getMySQLDatasource(){
        return new DatabaseDatesource() {
            @Override
            public List<String> getDatabase() {
                try{
                    Path filePath=new File(getClass().getResource("/data.txt").toURI()).toPath();
                    List<String> allLines= Files.readAllLines(filePath);
                    return allLines;
                }catch(URISyntaxException | IOException e){
                    e.printStackTrace();
                }
            return new ArrayList<>();
            }
        };
    }

}
