package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

}
