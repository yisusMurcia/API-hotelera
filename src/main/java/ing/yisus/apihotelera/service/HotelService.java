package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.HotelEntity;
import ing.yisus.apihotelera.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // Create, Read, Update, Delete (CRUD) methods for hotel management
    public HotelEntity saveHotel(HotelEntity hotel) {
       return hotelRepository.save(hotel);
    }
    public HotelEntity getHotelById(Integer id) {
        return hotelRepository.findById(id).orElse(null);
    }
    public void deleteHotel(Integer id) {
        HotelEntity hotel = getHotelById(id);
        if (hotel != null) {
            hotelRepository.delete(hotel);
        }
    }
    public HotelEntity updateHotel(HotelEntity hotel) {
        if (hotelRepository.existsById(hotel.getId())) {
            return hotelRepository.save(hotel);
        }
        return null; // or throw an exception
    }
    public List<HotelEntity> getAllHotels() {
        return hotelRepository.findAll();
    }
}
