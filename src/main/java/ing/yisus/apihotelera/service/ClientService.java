package ing.yisus.apihotelera.service;

import ing.yisus.apihotelera.Persistence.ClientEntity;
import ing.yisus.apihotelera.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //Create, Read, Update, Delete (CRUD) methods for client management
    public ClientEntity saveClient(ClientEntity client) {
        return clientRepository.save(client);
    }
    public ClientEntity getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }
    public void deleteClient(Integer id) {
        ClientEntity client = getClientById(id);
        if (client != null) {
            clientRepository.delete(client);
        }
    }
    public ClientEntity updateClient(ClientEntity client) {
        if (clientRepository.existsById(client.getId())) {
            return clientRepository.save(client);
        }
        return null; // or throw an exception
    }
    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }
}
