package pl.maciek_rychlinski.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.maciek_rychlinski.model.City;
import org.springframework.http.MediaType;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.springframework.data.rest.core.config.JsonSchemaFormat.URI;

@RestController
@RequestMapping("/cities")
public class CityController {

    private List<City> cities;

    public CityController() {
        cities = Collections.synchronizedList(new ArrayList<City>());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getCities(@RequestParam(defaultValue = "name") String orderBy) {
        List<City> cityCopy = new ArrayList<>(cities);
        if ("name".equals(orderBy)) {
            cityCopy.sort(Comparator.comparing(City::getName));
        } else if ("population".equals(orderBy)) {
            cityCopy.sort(Comparator.comparing(City::getPopulation));
        }
        return cityCopy;
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable int id) {
        if (id > cities.size() || id < 0) {
            return ResponseEntity.notFound().build();
        }
        City city = cities.get(id);
        return ResponseEntity.ok(city);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        if (!cities.contains(city)) {
            cities.add(city);
            java.net.URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(cities.size() - 1)
                    .toUri();
            return ResponseEntity.created(location).body(city);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
