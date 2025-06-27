package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    public abstract ArrayList<RoomEntity> getRoomsByRoomType(int roomTypeId);
}
