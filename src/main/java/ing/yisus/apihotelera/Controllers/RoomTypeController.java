package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.RoomEntity;
import ing.yisus.apihotelera.Persistence.RoomTypeEntity;
import ing.yisus.apihotelera.service.RoomService;
import ing.yisus.apihotelera.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RooomTypes")
@RequiredArgsConstructor
public class RoomTypeController {
    RoomService roomService;
    RoomTypeService roomTypeService;

    @GetMapping("/getAll")
    public List<RoomTypeEntity> obtenerTiposDeHabitacion(){
        return roomTypeService.obtenerTiposDeHabitacion();
    }
    @PostMapping()
    public RoomTypeEntity guardarTipoDeHabitacion(@RequestBody RoomTypeEntity roomType){
        return roomTypeService.saveRoomType(roomType);
    }
}
