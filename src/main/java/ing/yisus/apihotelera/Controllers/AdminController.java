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
    public ResponseEntity<AdminEntity> obtenerAdminPorId(@PathVariable("id") Integer id){
        AdminEntity admin = adminService.getAdminById(id);
        if (admin == null){
            ResponseEntity.badRequest();
            throw new ResourceNotFoundExeption("get","id",id);
        }
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarAdmin(@PathVariable("id") Integer id) {
        AdminEntity admin = adminService.getAdminById(id);
        if(adminService.getAdminById(id) == null){
            throw new ResourceNotFoundExeption("getById","adminId",id);
        }

        adminService.deleteAdmin(id);

        List<UserEntity> users = userService.getUsersByAdmin(admin);
        for (UserEntity user : users) {
            user.setAdmin(null);
            userService.saveUser(user);
        }

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody AdminEntity admin, @PathVariable("id") Integer id){
        return ResponseEntity.ok(adminService.updateAdmin(admin));
    }

    @PostMapping("/create")
    public ResponseEntity<AdminEntity> guardarAdmin(@RequestBody AdminEntity admin){
        return ResponseEntity.ok(adminService.saveAdmin(admin));
    }
}
