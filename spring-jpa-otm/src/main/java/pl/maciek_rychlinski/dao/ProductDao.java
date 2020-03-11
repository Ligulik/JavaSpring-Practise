package pl.maciek_rychlinski.dao;

import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.models.Order;
import pl.maciek_rychlinski.models.Product;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product,Long>{

}
