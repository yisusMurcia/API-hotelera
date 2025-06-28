package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.BillEntity;
import ing.yisus.apihotelera.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping("/getAll")
    public List<BillEntity> obtenerFacturas(){
        return billService.getBills();
    }

    @GetMapping("get/{id}")
    public BillEntity obtenerFacturaPorId(@PathVariable Integer id){
        return billService.getBillById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarFactura(@PathVariable Integer id){
        billService.deleteBill(id);
    }

    @PutMapping("/update/{id}")
    public void actualizarFactura(@RequestBody BillEntity bill, @PathVariable Integer id){
        billService.updateBill(bill);
    }


    @PostMapping("/create")
    public BillEntity guardarFactura(@RequestBody BillEntity bill){
        return billService.saveBill(bill);
    }
}
