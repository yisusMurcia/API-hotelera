package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.GeneralAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralAdminRepository extends JpaRepository<GeneralAdminEntity, Integer> {
}
