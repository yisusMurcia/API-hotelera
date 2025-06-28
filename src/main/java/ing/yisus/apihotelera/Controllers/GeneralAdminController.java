package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.GeneralAdminEntity;
import ing.yisus.apihotelera.Persistence.UserEntity;
import ing.yisus.apihotelera.service.GeneralAdminService;
import ing.yisus.apihotelera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generalAdmins")
public class GeneralAdminController {
    @Autowired
    GeneralAdminService generalAdminService;
    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GeneralAdminEntity>> obtenerGeneralAdmins(){
        return ResponseEntity.ok(generalAdminService.getAllGeneralAdmins());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GeneralAdminEntity> obtenerGeneralAdmin(@PathVariable Integer id){
        GeneralAdminEntity generalAdmin = generalAdminService.getGeneralAdminById(id);
        if(generalAdmin == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(generalAdmin);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarGeneralAdmin(@PathVariable Integer id){
        GeneralAdminEntity existingGeneralAdmin = generalAdminService.getGeneralAdminById(id);
        if(existingGeneralAdmin == null){
            return ResponseEntity.notFound().build();
        }
        //Set null the value in users
        List<UserEntity> users = userService.getUsersByGeneralAdmin(existingGeneralAdmin);
        for(UserEntity user : users){
            user.setGeneralAdmin(null);
            userService.saveUser(user);
        }

        generalAdminService.deleteGeneralAdmin(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GeneralAdminEntity> actualizarGeneralAdmin(@PathVariable Integer id, @RequestBody GeneralAdminEntity generalAdmin){
        GeneralAdminEntity existingGeneralAdmin = generalAdminService.getGeneralAdminById(id);
        if(existingGeneralAdmin == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(generalAdminService.updateGeneralAdmin(generalAdmin));
    }

    @PostMapping("/create")
    public ResponseEntity<GeneralAdminEntity>  guardarAdminGeneral(@RequestBody GeneralAdminEntity generalAdmin){
        if(generalAdminService.getGeneralAdminById(generalAdmin.getIdAdministradorGeneral()) != null){
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(generalAdminService.saveGeneralAdmin(generalAdmin));
    }
}
