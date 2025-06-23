package ing.yisus.apihotelera.Persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "administrador")
public class AdminEntity {
    @Id
    @Column(name = "id_administrador")
    private int idAdmin;
    private String correo;
    private String telefono;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
}
