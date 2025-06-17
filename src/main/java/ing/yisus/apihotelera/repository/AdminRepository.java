package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {}
