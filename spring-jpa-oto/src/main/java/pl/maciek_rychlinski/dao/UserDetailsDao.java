package pl.maciek_rychlinski.dao;

import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.models.UserDetails;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional

public class UserDetailsDao {

private EntityManager entityManager;

    public UserDetailsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserDetails get(Long id){
        UserDetails userDetails=entityManager.find(UserDetails.class,id);
        return userDetails;
    }
}
