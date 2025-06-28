package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.AdminEntity;
import ing.yisus.apihotelera.Persistence.BillEntity;
import ing.yisus.apihotelera.Persistence.PaymentEntity;
import ing.yisus.apihotelera.Persistence.ReservationEntity;
import ing.yisus.apihotelera.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private final BillRepository billRepository;
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    //Create, Read, Update, Delete (CRUD) methods for bill management
    public BillEntity saveBill(BillEntity bill) {
        return billRepository.save(bill);
    }

    public List<BillEntity> getBills() {
        return billRepository.findAll();
    }

    public BillEntity getBillById(Integer id) {
        return billRepository.findById(id).orElse(null);
    }
    public void deleteBill(Integer id) {
        BillEntity bill = getBillById(id);
        if (bill != null) {
            billRepository.delete(bill);
        }
    }
    public BillEntity updateBill(BillEntity bill) {
        if (billRepository.existsById(bill.getId())) {
            return billRepository.save(bill);
        }
        return null; // or throw an exception
    }

    public List<BillEntity> getAllBills() {
        return billRepository.findAll();
    }

    public List<BillEntity> getBillsByPayment(PaymentEntity payment) {
        return billRepository.findByPayment(payment);
    }


    public List<BillEntity> getBillsByReservation(ReservationEntity reservation) {
        return billRepository.findByReservation(reservation);
    }
}
