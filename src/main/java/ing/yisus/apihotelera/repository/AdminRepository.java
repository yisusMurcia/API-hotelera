package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {}
