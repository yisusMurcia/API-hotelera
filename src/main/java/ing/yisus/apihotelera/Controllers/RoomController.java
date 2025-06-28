package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.RoomEntity;
import ing.yisus.apihotelera.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    RoomService roomService;
    ReservationService reservationService;

    @GetMapping("/getAll")
    public List<RoomEntity> obtenerHabitaciones(){
        return roomService.getAllRooms();
    }

    @PostMapping()
    public RoomEntity guardarHabitacion(@RequestBody RoomEntity room){
        return roomService.saveRoom(room);
    }

    @GetMapping(path = "/{Id}")
    public Optional<RoomEntity> obtenerHabitacionPorId(@PathVariable("Id") int id){
        return roomService.getById(id);
    }

    @GetMapping("/getByType/{id}")
    public ResponseEntity<?> obtenerHabitacionPorTipo(@RequestParam("roomType") int id){
        if(roomService.getByType(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room type not found with id: " + id);
        }
        return ResponseEntity.ok(roomService.getByType(id));
    }

    @DeleteMapping(path = "/{Id}")
    public void eliminarHabitacionPorId(@PathVariable("Id") int id){
        roomService.deleteRoom(id);
    }
}
