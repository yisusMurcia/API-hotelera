package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.ReservationEntity;
import ing.yisus.apihotelera.Persistence.RoomEntity;
import ing.yisus.apihotelera.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    // Create, Read, Update, Delete (CRUD) methods for reservation management
    public ReservationEntity saveReservation(ReservationEntity reservation) {
        return reservationRepository.save(reservation);
    }
    public ReservationEntity getReservationById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }
    public void deleteReservation(Integer id) {
        ReservationEntity reservation = getReservationById(id);
        if (reservation != null) {
            reservationRepository.delete(reservation);
        }
    }
    public ReservationEntity updateReservation(ReservationEntity reservation) {
        if (reservationRepository.existsById(reservation.getId())) {
            return reservationRepository.save(reservation);
        }
        return null; // or throw an exception
    }
    public List<ReservationEntity> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<ReservationEntity> getReservationsByRoom(RoomEntity room) {
        return reservationRepository.findByRoom(room);
    }
}
