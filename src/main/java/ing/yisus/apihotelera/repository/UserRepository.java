package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
