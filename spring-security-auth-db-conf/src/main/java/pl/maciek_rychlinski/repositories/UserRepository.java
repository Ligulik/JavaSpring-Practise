package pl.maciek_rychlinski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciek_rychlinski.models.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
