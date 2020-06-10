package pl.maciek_rychlinski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.maciek_rychlinski.models.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    UserRole findByRole (String role);
}
