package pl.patrykkawula.carrental.client.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.client.dtos.ClientDto;
import pl.patrykkawula.carrental.client.exceptions.ClientNotFoundException;
import pl.patrykkawula.carrental.client.model.Client;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = map(clientDto);
        client.setAddress(null);
        clientRepository.save(client);
        client.setAddress(clientDto.address());
        clientRepository.save(client);
        return clientDto;
    }

    @Override
    @Transactional
    public ClientDto update(Long clientId, ClientDto clientDto) {
        return clientRepository.findById(clientId)
                .map(client -> updateClient(client, clientDto))
                .map(this::map)
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDto get(Long clientId) {
        return clientRepository.findById(clientId)
                .map(this::map)
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private ClientDto map(Client client) {
        return new ClientDto(client.getFirstName(), client.getLastName(), client.getEmail(), client.getPhoneNumber(),
                client.getDrivingLicenseNumber(), client.getDateOfBirth(), client.getBankAccount(), client.getAddress());
    }

    private Client map(ClientDto clientDto) {
        return new Client(clientDto.firstName(), clientDto.lastName(), clientDto.email(), clientDto.phoneNumber(),
                clientDto.bankAccount(), clientDto.dateOfBirth(), clientDto.drivingLicenseNumber(), clientDto.address());
    }

    private Client updateClient(Client client, ClientDto clientDto) {
        client.setFirstName(clientDto.firstName());
        client.setLastName(clientDto.lastName());
        client.setEmail(clientDto.email());
        client.setPhoneNumber(clientDto.phoneNumber());
        client.setBankAccount(clientDto.bankAccount());
        client.setDateOfBirth(clientDto.dateOfBirth());
        client.setDrivingLicenseNumber(clientDto.drivingLicenseNumber());
        client.setAddress(clientDto.address());
        return client;
    }
}
