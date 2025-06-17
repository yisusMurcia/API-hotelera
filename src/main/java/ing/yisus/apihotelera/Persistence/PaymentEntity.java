package ing.yisus.apihotelera.Persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "pago")
public class PaymentEntity implements Serializable {
    @Id
    private int id;
    @Column(name = "id_pago")
    private int idPago;
    private Timestamp fecha;
    @Column(name ="metodo_pago")
    private String metodoPago;
    @Column(name = "pago_total")
    private int pagoTotal;
    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    private ReservationEntity reservation;
}
