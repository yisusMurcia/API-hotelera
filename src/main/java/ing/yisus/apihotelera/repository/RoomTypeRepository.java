package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Integer> {
}
