package pl.maciek_rychlinski.dao;

import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public Product get(Long id){
        return entityManager.find(Product.class,id);
    }

    public void save(Product product){
        entityManager.persist(product);
    }

    public List<Product> getAll(){
        TypedQuery<Product> getAllQueries=entityManager.createNamedQuery("Product.findAll",Product.class);
        List<Product> resultList=getAllQueries.getResultList();
        return resultList;
    }

    public void  deleteAll(){
        Query deleteAllQueries=entityManager.createNamedQuery("Product.deleteAll");
        deleteAllQueries.executeUpdate();
    }

    public List<Product> getCustom(String jpqlQuerry){
        TypedQuery<Product> querry=entityManager.createQuery(jpqlQuerry,Product.class);
        return querry.getResultList();
    }

    public List<Product> findByName(String name){
        TypedQuery<Product> byNameQueries=entityManager.createNamedQuery("Product.findByName",Product.class);
        byNameQueries.setParameter("name",name);
        List<Product> list=byNameQueries.getResultList();
        return list;
    }

    public void deleteByProducer(String name){
        Query query=entityManager.createQuery("DELETE FROM Product p WHERE p.producer= :producer");
        query.setParameter("producer",name);
        query.executeUpdate();
    }
}
