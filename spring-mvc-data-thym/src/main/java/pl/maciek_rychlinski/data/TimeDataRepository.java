package pl.maciek_rychlinski.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.maciek_rychlinski.model.TimeData;

@Repository
public interface TimeDataRepository extends JpaRepository<TimeData, Long> {
}
