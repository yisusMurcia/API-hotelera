package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.AdminEntity;
import ing.yisus.apihotelera.Persistence.ClientEntity;
import ing.yisus.apihotelera.Persistence.GeneralAdminEntity;
import ing.yisus.apihotelera.Persistence.UserEntity;
import ing.yisus.apihotelera.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Create, Read, Update, Delete (CRUD) methods for user management
    public UserEntity saveUser(UserEntity user) {
       return userRepository.save(user);
    }
    public UserEntity getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
    public void deleteUser(Integer id) {
        UserEntity user = getUserById(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }
    public UserEntity updateUser(UserEntity user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null; // or throw an exception
    }
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserEntity> getUsersByAdmin(AdminEntity admin) {
        return userRepository.findByAdmin(admin);
    }

    public List<UserEntity> getUserByClient(ClientEntity client){
        return userRepository.findByClient((client));}

    public List<UserEntity> getUsersByGeneralAdmin(GeneralAdminEntity generalAdmin) {
        return userRepository.findByGeneralAdmin(generalAdmin);}
}
