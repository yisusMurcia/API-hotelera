package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.BillEntity;
import ing.yisus.apihotelera.service.BillService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping("/getAll")
    public ResponseEntity<List<BillEntity>> obtenerFacturas(){
        return ResponseEntity.ok(billService.getBills());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<BillEntity> obtenerFacturaPorId(@PathVariable Integer id){
        if(billService.getBillById(id) == null){
            ResponseEntity.notFound().build();
            throw new ResourceNotFoundExeption("get","id", id);
        }
        return ResponseEntity.ok(billService.getBillById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarFactura(@PathVariable Integer id){
        if(billService.getBillById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Bill not found with id: " + id);
        }
        billService.deleteBill(id);

        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BillEntity> actualizarFactura(@RequestBody BillEntity bill, @PathVariable Integer id){
        if(billService.getBillById(id) == null){
            ResponseEntity.badRequest();
            throw new ResourceNotFoundExeption("get","id", id);
        }
        return ResponseEntity.ok(billService.updateBill(bill));
    }


    @PostMapping("/create")
    public ResponseEntity<BillEntity> guardarFactura(@RequestBody BillEntity bill){
        return ResponseEntity.ok(billService.saveBill(bill));
    }
}
