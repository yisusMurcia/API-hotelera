package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
}
