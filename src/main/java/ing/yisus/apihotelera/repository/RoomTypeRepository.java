package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Integer> {
}
