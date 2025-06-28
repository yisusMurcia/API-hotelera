package ing.yisus.apihotelera.Persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario")
public class UserEntity implements Serializable {
    @Id
    @Column(name = "id_usuario")
    private int id;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "contrasena")
    private String password;
    private String rol;
    @OneToOne
    @JoinColumn(name= "fk_id_cliente")
    private ClientEntity client;
    @OneToOne
    @JoinColumn(name= "fk_id_empleado")
    private EmployeeEntity employee;
    @OneToOne
    @JoinColumn(name = "fk_id_administrador_general")
    private GeneralAdminEntity generalAdmin;
    @OneToOne
    @JoinColumn(name = "fk_id_administrador")
    private AdminEntity admin;
}
