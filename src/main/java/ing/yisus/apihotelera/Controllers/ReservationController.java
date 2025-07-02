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
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody ReservationEntity reservation, @PathVariable("id") Integer id){
        if(reservationService.getReservationById(id) == null){
            throw new ResourceNotFoundExeption("getByType","RoomtypeId",id);
        }
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }

    @GetMapping("/getByUser/{id}")
    public ResponseEntity<?> obtenerReservaPorUsuario(@RequestParam("id") int id){
        if(reservationService.getReservationById(id) == null){
            throw new ResourceNotFoundExeption("getByType","RoomtypeId",id);
        }

        return ResponseEntity.ok(reservationService.obtenerReservaPorUsuario(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarReserva(@PathVariable("id")int id ){
        if(reservationService.getReservationById(id) == null){
            throw new ResourceNotFoundExeption("getById","ReservationId",id);
        }
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

}
