package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.RoomTypeEntity;
import ing.yisus.apihotelera.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;
    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }
    // Create, Read, Update, Delete (CRUD) methods for room type management
    public void saveRoomType(RoomTypeEntity roomType) {
        roomTypeRepository.save(roomType);
    }
    public RoomTypeEntity getRoomTypeById(int id) {
        return roomTypeRepository.findById(id).orElse(null);
    }
    public void deleteRoomType(int id) {
        RoomTypeEntity roomType = getRoomTypeById(id);
        if (roomType != null) {
            roomTypeRepository.delete(roomType);
        }
    }
    public RoomTypeEntity updateRoomType(RoomTypeEntity roomType) {
        if (roomTypeRepository.existsById(roomType.getId())) {
            return roomTypeRepository.save(roomType);
        }
        return null; // or throw an exception
    }
}
