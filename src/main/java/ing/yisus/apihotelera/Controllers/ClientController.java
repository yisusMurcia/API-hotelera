package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.ClientEntity;
import ing.yisus.apihotelera.Persistence.UserEntity;
import ing.yisus.apihotelera.service.ClientService;
import ing.yisus.apihotelera.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    ClientService clientService;
    UserService userService;


    @GetMapping("getAll")
    public ResponseEntity<List<ClientEntity>> obtenerClientes(){
        return  ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ClientEntity> obtenerCliente(@PathVariable int id){
        if(clientService.getClientById(id) == null){
            ResponseEntity.badRequest();
            throw new ResourceNotFoundExeption("get","id", id);
        }
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ClientEntity> eliminarCliente(@PathVariable int id){
        ClientEntity client = clientService.getClientById(id);
        if(clientService.getClientById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Client not found with id: " + id);
        }
        clientService.deleteClient(id);

        //Delete client id from user
        List<UserEntity> users = userService.getUserByClient(client);
        for(UserEntity user : users){
            user.setClient(null);
            userService.saveUser(user);
        }
        return ResponseEntity.noContent(clientService.deleteClient(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientEntity> actualizarCliente(@PathVariable int id, @RequestBody ClientEntity cliente){
        if(clientService.getClientById(id) == null){
            ResponseEntity.badRequest();
            throw new ResourceNotFoundExeption("get","id", id);
        }
        return ResponseEntity.ok(clientService.updateClient(cliente));
    }

    @PostMapping("/create")
    public ResponseEntity<ClientEntity> guardarCliente(@RequestBody ClientEntity cliente){
        return ResponseEntity.ok(clientService.saveClient(cliente));
    }
}
