package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Exeption.ResourceNotFoundExeption;
import ing.yisus.apihotelera.Persistence.ClientEntity;
import ing.yisus.apihotelera.Persistence.UserEntity;
import ing.yisus.apihotelera.service.ClientService;
import ing.yisus.apihotelera.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    ClientService clientService;
    UserService userService;


    @GetMapping("getAll")
    public List<ClientEntity> obtenerClientes(){
        return  clientService.getAllClients();
    }

    @GetMapping("/get/{id}")
    public ClientEntity obtenerCliente(@PathVariable int id){
        if(clientService.getClientById(id) == null){
            throw new ResourceNotFoundExeption("get","id", id);
        }
        return clientService.getClientById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarCliente(@PathVariable int id){
        ClientEntity client = clientService.getClientById(id);
        if(clientService.getClientById(id) == null){
            throw new ResourceNotFoundExeption("get","id", id);
        }
        clientService.deleteClient(id);

        //Delete client id from user
        List<UserEntity> users = userService.getUserByClient(client);
        for(UserEntity user : users){
            user.setClient(null);
            userService.saveUser(user);
        }
    }

    @PutMapping("/update/{id}")
    public ClientEntity actualizarCliente(@PathVariable int id, @RequestBody ClientEntity cliente){
        if(clientService.getClientById(id) == null){
            throw new ResourceNotFoundExeption("get","id", id);
        }
        return clientService.updateClient(cliente);
    }

    @PostMapping("/create")
    public ClientEntity guardarCliente(@RequestBody ClientEntity cliente){
        return clientService.saveClient(cliente);
    }
}
