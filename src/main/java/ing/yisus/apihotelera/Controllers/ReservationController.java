package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.AdminEntity;
import ing.yisus.apihotelera.Persistence.ReservationEntity;
import ing.yisus.apihotelera.Persistence.UserEntity;
import ing.yisus.apihotelera.service.BillService;
import ing.yisus.apihotelera.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    BillService billService;

    @GetMapping("/getAll")
    public Iterable<ReservationEntity> obtenerReservas(){
        return reservationService.getAllReservations();
    }

    @PostMapping("/create")
    public ResponseEntity<?> guardarAdmin(@RequestBody ReservationEntity reservation){
        reservationService.saveReservation(reservation);
        return ResponseEntity.ok("GeneralAdmin created successfully: " );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody ReservationEntity reservation, @PathVariable("id") Integer id){
        if(reservationService.getReservationById(id) == null){
            throw new ResourceNotFoundExeption("getByType","RoomtypeId",id);
        }else {
            reservationService.updateReservation(reservation);
            return ResponseEntity.ok("Reservation updated successfully: ");
        }
    }

    @GetMapping("/getByUser/{id}")
    public ResponseEntity<?> obtenerReservaPorUsuario(@RequestParam("id") int id){
        if(reservationService.getReservationById(id) == null){
            throw new ResourceNotFoundExeption("getByType","RoomtypeId",id);
        }else{
            reservationService.getReservationById(id);
            return ResponseEntity.ok("Reservations found by user: " + id);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarReserva(@PathVariable("id")int id ){
        if(reservationService.getReservationById(id) == null){
            throw new ResourceNotFoundExeption("getById","ReservationId",id);
        }else{
            reservationService.deleteReservation(id);
            return ResponseEntity.ok("Reservation deleted successfully");
        }
    }

}
