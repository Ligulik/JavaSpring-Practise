package pl.maciek_rychlinski.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
}
