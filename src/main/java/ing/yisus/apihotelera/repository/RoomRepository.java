package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.HotelEntity;
import ing.yisus.apihotelera.Persistence.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    public ArrayList<RoomEntity> getRoomsByRoomType(int roomTypeId);

    List<RoomEntity> findByHotel(HotelEntity hotel);
}
