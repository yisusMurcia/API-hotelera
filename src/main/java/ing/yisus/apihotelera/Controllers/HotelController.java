package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.HotelEntity;
import ing.yisus.apihotelera.repository.HotelRepository;
import ing.yisus.apihotelera.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping()
    public List<HotelEntity> obtenerHoteles(){
        return hotelService.getAllHotels();
    }

    @PostMapping()
    public HotelEntity guardarHoteles(@RequestBody HotelEntity hotel){
        return hotelService.saveHotel(hotel);
    }
}
