package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.BillEntity;
import ing.yisus.apihotelera.Persistence.PaymentEntity;
import ing.yisus.apihotelera.Persistence.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<BillEntity,Integer> {
    List<BillEntity> findByPayment(PaymentEntity payment);

    List<BillEntity> findByReservation(ReservationEntity reservation);
}
