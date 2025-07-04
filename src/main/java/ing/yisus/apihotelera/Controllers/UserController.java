package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.UserEntity;
import ing.yisus.apihotelera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public List<UserEntity> obtenerUsuarios(){
        return userService.getAllUsers();
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarUsuario(@RequestBody UserEntity user){
        userService.saveUser(user);
        return ResponseEntity.ok("User created successfully");
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable("id") int id, @RequestBody UserEntity user){
        UserEntity isEmpty = userService.getUserById(id);
        if (isEmpty == null ){
            throw  new ResourceNotFoundExeption("USER_NOT_FOUND","id",id);
        }else {
            userService.updateUser(user);
            return ResponseEntity.ok("User updated successfully: ");
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> eliminarUsuario(@RequestParam("id") Integer id){
        UserEntity isEmpty = userService.getUserById(id);
        if (isEmpty == null ){
            throw  new ResourceNotFoundExeption("USER_NOT_FOUND","id",id);
        }else {
            userService.deleteUser(id);
        }
        return ResponseEntity.ok("User deleted successfully");
    }
}
