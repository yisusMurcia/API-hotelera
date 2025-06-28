package ing.yisus.apihotelera.repository;

import ing.yisus.apihotelera.Persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public List<UserEntity> findByAdmin(AdminEntity admin);

    List<UserEntity> findByClient(ClientEntity cliente);

    List<UserEntity> findByGeneralAdmin(GeneralAdminEntity generalAdmin);
}
