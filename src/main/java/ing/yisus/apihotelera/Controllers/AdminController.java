package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.AdminEntity;
import ing.yisus.apihotelera.Persistence.UserEntity;
import ing.yisus.apihotelera.service.AdminService;
import ing.yisus.apihotelera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public List<AdminEntity> obtenerAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/get/{id}")
    public AdminEntity obtenerAdminPorId(@PathVariable("id") Integer id){
        AdminEntity admin = adminService.getAdminById(id);
        if (admin == null){
            throw new ResourceNotFoundExeption("get","id",id);
        }
        return adminService.getAdminById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarAdmin(@PathVariable("id") Integer id){
        AdminEntity admin = adminService.getAdminById(id);
        if (admin == null){
            throw new ResourceNotFoundExeption("delete","id",id);
        }
        adminService.deleteAdmin(id);
        //Delete the admin id from users
        List<UserEntity> users = userService.getUsersByAdmin(admin);

        for (UserEntity user : users) {
            user.setAdmin(null);
            userService.saveUser(user);
        }

    }

    @PutMapping("/update/{id}")
    public void updateAdmin(@RequestBody AdminEntity admin, @PathVariable("id") Integer id){
        adminService.updateAdmin(admin);

    }

    @PostMapping("/create")
    public AdminEntity guardarAdmin(@RequestBody AdminEntity admin){
        return adminService.saveAdmin(admin);
    }
}
