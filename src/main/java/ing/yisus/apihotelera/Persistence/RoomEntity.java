package ing.yisus.apihotelera.Persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "habitacion")
public class RoomEntity implements Serializable {
    @Id
    @Column(name = "id_habitacion")
    private int id;
    @Column(name = "numero_habitacion")
    private int numeroDeHabitacion;
    @OneToOne
    @JoinColumn(name = "fk_id_tipo_habitacion")
    private RoomTypeEntity roomType;
    @Column(name = "precio_dia")
    private int precioDia;
    private boolean disponible;
    @ManyToOne
    @JoinColumn(name = "fk_id_hotel")
    private HotelEntity hotel;

}
