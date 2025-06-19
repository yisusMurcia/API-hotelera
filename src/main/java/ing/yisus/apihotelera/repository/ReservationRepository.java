package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.ReservationEntity;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
}
