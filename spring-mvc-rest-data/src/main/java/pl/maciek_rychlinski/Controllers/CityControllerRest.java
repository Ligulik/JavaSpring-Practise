package pl.maciek_rychlinski.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciek_rychlinski.model.City;
import pl.maciek_rychlinski.repository.CityRepository;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityControllerRest {

    public CityRepository citiRepo;

    @Autowired
    public CityControllerRest(CityRepository cityRepository){
        this.citiRepo=cityRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getCities(@RequestParam(defaultValue = "name") String orderBy){
        List<City> cities=citiRepo.findAll();
        if("name".equals(orderBy)){
            cities.sort(Comparator.comparing(City::getName));
        }else if("population".equals(orderBy)){
            cities.sort(Comparator.comparing(City::getPopulation));
        }
    return cities;
    }


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCityById(@PathVariable Long id){
        return citiRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCity(@RequestBody City city){
        citiRepo.save(city);
    }
}
