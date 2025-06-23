package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.BillEntity;
import ing.yisus.apihotelera.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping()
    public List<BillEntity> obtenerFacturas(){
        return billService.getBills();
    }

    @PostMapping()
    public BillEntity guardarFactura(@RequestBody BillEntity bill){
        return billService.saveBill(bill);
    }
}
