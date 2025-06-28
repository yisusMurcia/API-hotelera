package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.EmployeeEntity;
import ing.yisus.apihotelera.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeEntity>> obtenerEmpleados(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeEntity> guardarEmpleado(@RequestBody EmployeeEntity employee){
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }
}
