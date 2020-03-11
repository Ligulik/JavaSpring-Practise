package pl.maciek_rychlinski.dao;

import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.models.Order;
import pl.maciek_rychlinski.models.Product;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDao   extends GenericDao<Order,Long> {

    public void addProductToOrder(Long orderId, Product... products){
        Order order=get(orderId);
        if(order!=null){
            for(Product product:products){
                order.getProducts().add(product);
            }
        }
    }
}
