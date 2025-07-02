package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.HotelEntity;
import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.RoomEntity;
import ing.yisus.apihotelera.service.HotelService;
import ing.yisus.apihotelera.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
    HotelService hotelService;
    RoomService roomService;

    @GetMapping("/getAll")
    public ResponseEntity<List<HotelEntity>> obtenerHoteles(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @PostMapping("update/{id}")
    public ResponseEntity<HotelEntity> guardarHoteles(@RequestBody HotelEntity hotel, @RequestParam Integer id){
        if(hotelService.getHotelById(id) == null){
            throw new ResourceNotFoundExeption("getById","generalAdminId",id);
        }
        return ResponseEntity.ok(hotelService.saveHotel(hotel));
    }
}
