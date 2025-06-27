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
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping()
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

    @GetMapping("/query")
    public ArrayList<RoomEntity> obtenerHabitacionPorTipo(@RequestParam("roomType") int type){
        return roomService.getByType(type);
    }

    @DeleteMapping(path = "/{Id}")
    public void eliminarHabitacionPorId(@PathVariable("Id") int id){
        roomService.deleteRoom(id);
    }
}
