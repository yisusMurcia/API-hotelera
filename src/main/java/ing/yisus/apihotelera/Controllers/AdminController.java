package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.AdminEntity;
import ing.yisus.apihotelera.Persistence.UserEntity;
import ing.yisus.apihotelera.service.AdminService;
import ing.yisus.apihotelera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<AdminEntity>> obtenerAdmins(){
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> obtenerAdminPorId(@PathVariable("id") Integer id){
        if(adminService.getAdminById(id) == null){
            throw new ResourceNotFoundExeption("get","id", id);
        }else {
            adminService.getAdminById(id);
            return ResponseEntity.ok("Admin found with id" + id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarAdmin(@PathVariable("id") Integer id) {
        if(adminService.getAdminById(id) == null){
            throw new ResourceNotFoundExeption("get","id", id);
        }else {
            List<UserEntity> users = userService.getUsersByAdmin(adminService.getAdminById(id));
            for (UserEntity user : users) {
                user.setAdmin(null);
                userService.saveUser(user);
            }
            adminService.deleteAdmin(id);
            return ResponseEntity.ok("bill updated");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody AdminEntity admin, @PathVariable("id") Integer id){
        if(adminService.getAdminById(id) == null){
            throw new ResourceNotFoundExeption("get","id", id);
        }else {
            adminService.updateAdmin(admin);
            return ResponseEntity.ok("bill updated");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<AdminEntity> guardarAdmin(@RequestBody AdminEntity admin){
        return ResponseEntity.ok(adminService.saveAdmin(admin));
    }
}
