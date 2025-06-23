package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.AdminEntity;
import ing.yisus.apihotelera.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping()
    public List<AdminEntity> obtenerAdmins(){
        return adminService.getAllAdmins();
    }

    @PostMapping()
    public AdminEntity guardarAdmin(@RequestBody AdminEntity admin){
        return adminService.saveAdmin(admin);
    }
}
