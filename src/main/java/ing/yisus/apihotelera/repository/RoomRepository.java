package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
}
