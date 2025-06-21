package ing.yisus.apihotelera.service;

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
    public void saveUser(UserEntity user) {
        userRepository.save(user);
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
}
