package pl.maciek_rychlinski.dao;

import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.models.Client;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client,Long> {
}
