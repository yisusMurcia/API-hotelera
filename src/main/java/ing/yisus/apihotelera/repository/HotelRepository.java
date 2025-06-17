package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {}