package pl.maciek_rychlinski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.model.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
