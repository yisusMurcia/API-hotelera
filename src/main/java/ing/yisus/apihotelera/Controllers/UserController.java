package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.UserEntity;
import ing.yisus.apihotelera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public List<UserEntity> obtenerUsuarios(){
        return userService.getAllUsers();
    }

    @PostMapping()
    public UserEntity guardarUsuario(@RequestBody UserEntity user){
        return userService.saveUser(user);
    }
}
