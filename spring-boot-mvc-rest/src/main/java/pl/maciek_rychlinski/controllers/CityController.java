package pl.maciek_rychlinski.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maciek_rychlinski.model.City;


@RestController
public class CityController {

    @RequestMapping(path = "/city",
    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public City getCity(){
        return new City("Szczecin",100000);
    }
}
