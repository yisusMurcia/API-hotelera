package ing.yisus.apihotelera.Persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "reserva")
public class ReservationEntity implements Serializable {
    @Id
    @Column(name = "id_reserva")
    private int id_reserva;
    private Timestamp fecha_inicio;
    private Timestamp fecha_final;
    private int cantidad_dias;
    private boolean estado;
    private Timestamp fecha_reserva;
    @ManyToOne
    @JoinColumn(name = "fk_id_cliente")
    private ClientEntity client;
    @ManyToOne
    @JoinColumn(name = "fk_id_habitacion")
    private RoomEntity room;

}
