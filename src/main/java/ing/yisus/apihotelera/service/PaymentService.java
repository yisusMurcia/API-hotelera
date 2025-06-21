package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.PaymentEntity;
import ing.yisus.apihotelera.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    // Create, Read, Update, Delete (CRUD) methods for payment management
    public void savePayment(PaymentEntity payment) {
        paymentRepository.save(payment);
    }
    public PaymentEntity getPaymentById(Integer id) {
        return paymentRepository.findById(id).orElse(null);
    }
    public void deletePayment(Integer id) {
        PaymentEntity payment = getPaymentById(id);
        if (payment != null) {
            paymentRepository.delete(payment);
        }
    }
    public PaymentEntity updatePayment(PaymentEntity payment) {
        if (paymentRepository.existsById(payment.getId())) {
            return paymentRepository.save(payment);
        }
        return null; // or throw an exception
    }
    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.findAll();
    }
}
