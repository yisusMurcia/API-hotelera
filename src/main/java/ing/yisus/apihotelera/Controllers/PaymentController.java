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
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    public List<PaymentEntity> obtenerPagos(){
        return paymentService.getAllPayments();
    }

    public PaymentEntity guardarPago(@RequestBody PaymentEntity payment){
        return paymentService.savePayment(payment);
    }
}
