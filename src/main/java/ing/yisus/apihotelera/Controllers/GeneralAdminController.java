package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.GeneralAdminEntity;
import ing.yisus.apihotelera.service.GeneralAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generalAdmins")
public class GeneralAdminController {
    @Autowired
    GeneralAdminService generalAdminService;

    @GetMapping()
    public List<GeneralAdminEntity> obtenerGeneralAdmins(){
        return generalAdminService.getAllGeneralAdmins();
    }

    @PostMapping()
    public GeneralAdminEntity  guardarAdminGeneral(@RequestBody GeneralAdminEntity generalAdmin){
        return generalAdminService.saveGeneralAdmin(generalAdmin);
    }
}
