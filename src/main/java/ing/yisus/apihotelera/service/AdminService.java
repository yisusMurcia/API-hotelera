package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.AdminEntity;
import ing.yisus.apihotelera.Persistence.HotelEntity;
import ing.yisus.apihotelera.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    //Create, Read, Update, Delete (CRUD) methods for hotel management
    public AdminEntity saveAdmin(AdminEntity admin) {
        return adminRepository.save(admin);
    }

    public List<AdminEntity> getAllAdmins() {
        return adminRepository.findAll();
    }

    public AdminEntity getAdminById(Integer id) {
        return adminRepository.findById(id).orElse(null);
    }

    public AdminEntity deleteAdmin(Integer id) {
        AdminEntity admin = getAdminById(id);
        if (admin != null) {
            adminRepository.delete(admin);
        }
        return admin;
    }

    public AdminEntity updateAdmin(AdminEntity admin) {
        if (adminRepository.existsById(admin.getIdAdmin())) {
            return adminRepository.save(admin);
        }
        return null; // or throw an exception
    }
}
