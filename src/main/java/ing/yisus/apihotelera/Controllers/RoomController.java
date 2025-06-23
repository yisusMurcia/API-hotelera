package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.RoomEntity;
import ing.yisus.apihotelera.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
