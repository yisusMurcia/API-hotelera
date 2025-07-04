package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.PaymentEntity;
import ing.yisus.apihotelera.service.BillService;
import ing.yisus.apihotelera.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        paymentService.savePayment(payment);
        return ResponseEntity.ok("Payment saved sucessfully");
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<?> actualizarPago(@RequestBody PaymentEntity payment, @PathVariable("id") int id){
        if (this.paymentService.getPaymentById(id) == null){
            throw new ResourceNotFoundExeption("PAYMENT_NOT_FOUND","id",id);
        }else {
            paymentService.savePayment(payment);
            return ResponseEntity.ok("Payment updated sucessfully");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarPago(@PathVariable("id")int id){
        if (paymentService.getPaymentById(id) == null){
            throw new ResourceNotFoundExeption("PAYMENT_NOT_FOUND","id",id);
        }else {
            paymentService.getPaymentById(id);
            return ResponseEntity.ok("Payment deleted sucessfully");
        }
    }
}
