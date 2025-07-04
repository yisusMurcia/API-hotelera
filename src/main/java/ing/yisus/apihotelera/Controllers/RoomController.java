package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.RoomEntity;
import ing.yisus.apihotelera.service.ReservationService;
import ing.yisus.apihotelera.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if(roomService.getById(id).isEmpty()){
            throw new ResourceNotFoundExeption("getById","RoomId",id);
        }
        return roomService.getById(id);
    }

    @GetMapping("/getByType/{id}")
    public ResponseEntity<?> obtenerHabitacionPorTipo(@RequestParam("roomType") int id){
        if(roomService.getByType(id) == null){
            throw new ResourceNotFoundExeption("getByType","RoomtypeId",id);
        }else{
            roomService.getByType(id);
            return ResponseEntity.ok("Rooms found by type: " + id);
        }
    }

    @DeleteMapping(path = "delete/{Id}")
    public ResponseEntity<?> eliminarHabitacionPorId(@PathVariable("Id") int id){
        RoomEntity isEmpty = roomService.getRoomById(id);
        if (isEmpty == null){
            throw new ResourceNotFoundExeption("getById","RoomId",id);
        }else {
            roomService.deleteRoom(id);
            return ResponseEntity.ok("Room deleted successfully");
        }
    }
}
