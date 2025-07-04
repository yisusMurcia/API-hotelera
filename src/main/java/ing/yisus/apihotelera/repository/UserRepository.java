package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByAdmin(AdminEntity admin);

    List<UserEntity> findByClient(ClientEntity cliente);

    List<UserEntity> findByGeneralAdmin(GeneralAdminEntity generalAdmin);

    Optional<UserEntity> findByNombreUsuario(String username);
}
