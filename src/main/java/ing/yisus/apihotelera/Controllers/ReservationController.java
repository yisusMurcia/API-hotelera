package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.ReservationEntity;
import ing.yisus.apihotelera.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping()
    public Iterable<ReservationEntity> obtenerReservas(){
        return reservationService.getAllReservations();
    }

    @PostMapping()
    public ReservationEntity guardarReserva(@RequestBody ReservationEntity reservation){
        return  reservationService.saveReservation(reservation);
    }
}
