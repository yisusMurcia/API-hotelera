package ing.yisus.apihotelera.Persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "factura")
public class BillEntity implements Serializable {

    @Id
    @Column(name = "id_factura")
    private int id;
    @ManyToOne
    @JoinColumn(name = "fk_id_reserva")
    private ReservationEntity reservation;
    @OneToOne
    @JoinColumn(name = "fk_id_pago")
    private PaymentEntity payment;
    @Column(name = "fecha_emision")
    private int fechaEmision;
    @Column(name = "valor_total")
    private int valorTotal;

}
