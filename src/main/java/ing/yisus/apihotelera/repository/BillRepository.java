package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillEntity,Integer> {
}
