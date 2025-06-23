package ing.yisus.apihotelera.Controllers;

import ing.yisus.apihotelera.Persistence.ClientEntity;
import ing.yisus.apihotelera.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping()
    public List<ClientEntity> obtenerClientes(){
        return  clientService.getAllClients();
    }
    @PostMapping()
    public ClientEntity guardarCliente(@RequestBody ClientEntity cliente){
        return clientService.saveClient(cliente);
    }
}
