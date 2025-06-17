package ing.yisus.apihotelera.Persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
@Table(name = "tipo_habitacion")
public class RoomTypeEntity {
    @Id
    @Column(name = "id_tipo_habitacion")
    private int id_tipo;
    @ManyToOne
    @JoinColumn(name = "fk_id_hotel")
    private HotelEntity hotel;
    private String nombre;
    private int cantidad;
}
