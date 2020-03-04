package pl.maciek_rychlinski.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.maciek_rychlinski.config.DatabaseDatesource;

import java.util.List;

@Component
public class NamesRepository {

    private DatabaseDatesource ds;

    @Autowired
    public NamesRepository(DatabaseDatesource ds){
        this.ds=ds;
    }

    public List<String> getAll(){
        return ds.getDatabase();
    }
}
