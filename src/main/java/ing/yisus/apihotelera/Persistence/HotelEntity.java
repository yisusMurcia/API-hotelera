package ing.yisus.apihotelera.Persistence;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "hotel")
public class HotelEntity implements Serializable {
    @Id
    @Column(name = "id_hotel")
    private int id;
    private String nombre;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String correo;




}
