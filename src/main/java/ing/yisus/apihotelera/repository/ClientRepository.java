package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
