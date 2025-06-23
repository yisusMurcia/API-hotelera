package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.EmployeeEntity;
import ing.yisus.apihotelera.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public List<EmployeeEntity> obtenerEmpleados(){
        return employeeService.getAllEmployees();
    }

    @PostMapping()
    public EmployeeEntity guardarEmpleado(@RequestBody EmployeeEntity employee){
        return employeeService.saveEmployee(employee);
    }
}
