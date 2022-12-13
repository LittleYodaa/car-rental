package pl.patrykkawula.carrental.client.service;

import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.client.model.Client;
@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
        return null;
    }

    @Override
    public Client update(Long clientId) {
        return null;
    }

    @Override
    public void delete(Long clientId) {

    }

    @Override
    public Client get(Long clientId) {
        return null;
    }
}
