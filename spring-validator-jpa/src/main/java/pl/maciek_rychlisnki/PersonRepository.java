package pl.maciek_rychlisnki;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Typowe repozytorium z transakcją dodającą danego użytkowanika do bazy danych
 */

@Repository
public class PersonRepository {

    private EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void add(Person person) {
        entityManager.persist(person);
    }
}
