package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.RoomEntity;
import ing.yisus.apihotelera.Persistence.RoomTypeEntity;
import ing.yisus.apihotelera.service.RoomService;
import ing.yisus.apihotelera.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/saveRoomType")
    public ResponseEntity<?> guardarTipoDeHabitacion(@RequestBody RoomTypeEntity roomType){
        roomTypeService.saveRoomType(roomType);
        return ResponseEntity.ok("RoomType created successfully");
    }
    @PostMapping("/updateRoomType/{id}")
    public  ResponseEntity<?> actualizarTipoDeHabitacion(@PathVariable("id") int id, @RequestBody RoomTypeEntity roomType){
        RoomTypeEntity isEmpty = roomTypeService.getRoomTypeById(id);
        if (isEmpty == null ){
            throw new ResourceNotFoundExeption("ROOM_TYPE_NOT_FOUND","id",id);
        }else {
            roomTypeService.updateRoomType(roomType);
            return ResponseEntity.ok("RoomType updated successfully: ");
        }
    }
    @DeleteMapping("/deleteRoomType/{id}")
    public ResponseEntity<?> eliminarTipoDeHabitacion(@PathVariable("id") int id){
        RoomTypeEntity isEmpty = roomTypeService.getRoomTypeById(id);
        if (isEmpty == null ){
            throw new ResourceNotFoundExeption("ROOM_TYPE_NOT_FOUND","id",id);
        }else {
            roomTypeService.deleteRoomType(id);
            return ResponseEntity.ok("RoomType deleted successfully");
        }
    }
}
