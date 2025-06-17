package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
