package pl.maciek_rychlinski.repository;

import jdk.jfr.Name;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.model.Car;

import javax.transaction.Transactional;
import java.util.List;


@Repository

public interface CarRepository extends CrudRepository<Car,Long> {

    List<Car> findByBrand(String brand);
    Car findFirstByBrand(String brand);
    List<Car> findAllByBrandOrBrand(String brand, String brand1);
    List<Car> findAllByNameLike(String name);
    List<Car> findAllByPriceBetween(Double lowerPrice, Double upperPrice);
    List<Car> findAllByBrandOrderByPriceAsc(String brand);

    @Query(name = "Car.FindByNameAndBrand")
    List<Car> findByNameAndBrand(@Param("name")String name,
                                 @Param("brand") String brand);
}
