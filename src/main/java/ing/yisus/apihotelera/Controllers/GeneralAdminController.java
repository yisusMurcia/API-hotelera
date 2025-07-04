package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
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
    public ResponseEntity<?> obtenerGeneralAdmin(@PathVariable Integer id){
        GeneralAdminEntity generalAdmin = generalAdminService.getGeneralAdminById(id);
        if(generalAdminService.getGeneralAdminById(id) == null){
            throw new ResourceNotFoundExeption("getById","generalAdminId",id);
        }else {
            generalAdminService.getGeneralAdminById(id);
            return ResponseEntity.ok("generalAdmin found with id"+id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarGeneralAdmin(@PathVariable Integer id){
        GeneralAdminEntity existingGeneralAdmin = generalAdminService.getGeneralAdminById(id);
        if(generalAdminService.getGeneralAdminById(id) == null){
            throw new ResourceNotFoundExeption("getById","generalAdminId",id);
        }else{
            //Set null the value in users
            List<UserEntity> users = userService.getUsersByGeneralAdmin(existingGeneralAdmin);
            for(UserEntity user : users){
                user.setGeneralAdmin(null);
                userService.saveUser(user);
            }
            generalAdminService.deleteGeneralAdmin(id);
            return ResponseEntity.ok("General admin deleted successfully");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarGeneralAdmin(@PathVariable Integer id, @RequestBody GeneralAdminEntity generalAdmin){
        if(generalAdminService.getGeneralAdminById(id) == null){
            throw new ResourceNotFoundExeption("getById","generalAdminId",id);
        }else {
            generalAdminService.updateGeneralAdmin(generalAdmin);
            return ResponseEntity.ok("General admin updated sucessfully");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?>  guardarAdminGeneral(@RequestBody GeneralAdminEntity generalAdmin){
        generalAdminService.saveGeneralAdmin(generalAdmin);
        return ResponseEntity.ok("General admin saved sucessfully");
    }
}
