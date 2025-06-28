package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.PaymentEntity;
import ing.yisus.apihotelera.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private BillService billService;

    @GetMapping("/getAll")
    public ResponseEntity<List<PaymentEntity>> obtenerPagos(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PostMapping("/create")
    public ResponseEntity<?> guardarPago(@RequestBody PaymentEntity payment){
        if (paymentService.getPaymentById(payment.getId()) == null){
            return ResponseEntity.ok(paymentService.savePayment(payment));
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment already exists with id: " + payment.getId());
    }
}
