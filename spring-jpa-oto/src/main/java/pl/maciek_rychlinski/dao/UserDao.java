package pl.maciek_rychlinski.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.models.User;
import pl.maciek_rychlinski.models.UserDetails;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {
    private EntityManager entityManager;

    @Autowired
    public UserDao(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public void save(User user){
        UserDetails userDetails=user.getDetails();
        if(userDetails!=null&& userDetails.getId()==null){
            entityManager.persist(userDetails);
        }
        entityManager.persist(user);
    }

    public User read(Long id){
        User user=entityManager.find(User.class,id);
        return user;
    }

    @Transactional
    public void upload(User user){
        UserDetails userDetails=user.getDetails();
        if(userDetails!=null){
            entityManager.merge(userDetails);
            user.setDetails(userDetails);
        }
        entityManager.merge(user);
    }

    public void delete(User user){
        User userToDelete=entityManager.merge(user);
        entityManager.remove(userToDelete.getDetails());
        entityManager.remove(userToDelete);
    }
}
