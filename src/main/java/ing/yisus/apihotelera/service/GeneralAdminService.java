package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.GeneralAdminEntity;
import ing.yisus.apihotelera.repository.GeneralAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralAdminService {
    private final GeneralAdminRepository generalAdminRepository;
    public GeneralAdminService(GeneralAdminRepository generalAdminRepository) {
        this.generalAdminRepository = generalAdminRepository;
    }

    //Create, Read, Update, Delete (CRUD) methods for general admin management
    public void saveGeneralAdmin(GeneralAdminEntity generalAdmin) {
        generalAdminRepository.save(generalAdmin);
    }
    public GeneralAdminEntity getGeneralAdminById(Integer id) {
        return generalAdminRepository.findById(id).orElse(null);
    }

    public void deleteGeneralAdmin(Integer id) {
        GeneralAdminEntity generalAdmin = getGeneralAdminById(id);
        if (generalAdmin != null) {
            generalAdminRepository.delete(generalAdmin);
        }
    }
    public GeneralAdminEntity updateGeneralAdmin(GeneralAdminEntity generalAdmin) {
        if (generalAdminRepository.existsById(generalAdmin.getId())) {
            return generalAdminRepository.save(generalAdmin);
        }
        return null; // or throw an exception
    }
    public List<GeneralAdminEntity> getAllGeneralAdmins() {
        return generalAdminRepository.findAll();
    }
}
