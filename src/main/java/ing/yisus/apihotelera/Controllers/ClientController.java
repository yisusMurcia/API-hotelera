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
    public ResponseEntity<?> obtenerCliente(@PathVariable int id){
        if (clientService.getClientById(id) == null){
            throw new ResourceNotFoundExeption("CLIENT_NOT_FOUND","id",id);
        }else{
            clientService.getClientById(id);
            return ResponseEntity.ok("Employee found with id" + id);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable int id){
        ClientEntity client = clientService.getClientById(id);
        if(clientService.getClientById(id) == null){
            throw new ResourceNotFoundExeption("getById","clientId",id);
        }else{
            //Delete client id from user
            List<UserEntity> users = userService.getUserByClient(client);
            for(UserEntity user : users){
                user.setClient(null);
                userService.saveUser(user);
            }
            clientService.deleteClient(id);
            return ResponseEntity.ok("Client deleted successfuly");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable int id, @RequestBody ClientEntity cliente){
        if(clientService.getClientById(id) == null){
            throw new ResourceNotFoundExeption("update","id", id);
        }else {
            clientService.updateClient(cliente);
            return ResponseEntity.ok("Client updated");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ClientEntity> guardarCliente(@RequestBody ClientEntity cliente){
        return ResponseEntity.ok(clientService.saveClient(cliente));
    }
}
