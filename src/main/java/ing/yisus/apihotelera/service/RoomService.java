package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.RoomEntity;
import ing.yisus.apihotelera.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    // Create, Read, Update, Delete (CRUD) methods for room management
    public RoomEntity getRoomById(int id) {
        return roomRepository.findById(id).orElse(null);
    }
    public RoomEntity saveRoom(RoomEntity room) {
        return roomRepository.save(room);
    }
    public void deleteRoom(int id) {
        RoomEntity room = getRoomById(id);
        if (room != null) {
            roomRepository.delete(room);
        }
    }
    public RoomEntity updateRoom(RoomEntity room) {
        if (roomRepository.existsById(room.getId())) {
            return roomRepository.save(room);
        }
        return null; // or throw an exception
    }
    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }
}
