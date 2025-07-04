package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
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
    public ResponseEntity<?> guardarEmpleado(@RequestBody EmployeeEntity employee){
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }
    @PostMapping("/getById/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable("id")int id){
        if (employeeService.getEmployeeById(id) == null){
            throw new ResourceNotFoundExeption("EMPLOYEE_NOT_FOUND","id",id);
        }else{
            employeeService.getEmployeeById(id);
            return ResponseEntity.ok("Employee found with id" + id);
        }
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable("id")int id, EmployeeEntity employee){
        if (employeeService.getEmployeeById(id) == null){
            throw new ResourceNotFoundExeption("EMPLOYEE_NOT_FOUND","id",id);
        }else{
            employeeService.saveEmployee(employee);
            return ResponseEntity.ok("Employee updated");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable("id")int id){
        if (employeeService.getEmployeeById(id) == null){
            throw new ResourceNotFoundExeption("EMPLOYEE_NOT_FOUND","id",id);
        }else{
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok("Employee deleted");
        }
    }
}
