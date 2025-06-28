package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.ReservationEntity;
import ing.yisus.apihotelera.Persistence.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
    List<ReservationEntity> findByRoom(RoomEntity room);
    List<ReservationEntity> findByUser(int userId);

    ReservationEntity getByUser(int idUsuario);
}
