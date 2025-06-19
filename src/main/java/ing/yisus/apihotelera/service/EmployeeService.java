package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.ClientEntity;
import ing.yisus.apihotelera.Persistence.EmployeeEntity;
import ing.yisus.apihotelera.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Create, Read, Update, Delete (CRUD) methods for employee management
    public void saveEmployee(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }
    public EmployeeEntity getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public void deleteEmployee(Integer id) {
        EmployeeEntity employee = getEmployeeById(id);
        if (employee != null) {
            employeeRepository.delete(employee);
        }
    }
    public EmployeeEntity updateEmployee(EmployeeEntity employee) {
        if (employeeRepository.existsById(employee.getId())) {
            return employeeRepository.save(employee);
        }
        return null; // or throw an exception
    }
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
