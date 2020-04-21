package pl.maciek_rychlinski.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.maciek_rychlinski.Models.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
}
