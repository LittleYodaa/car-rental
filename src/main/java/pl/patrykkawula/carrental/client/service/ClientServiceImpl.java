package pl.patrykkawula.carrental.client.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.client.address.dtos.AddressDto;
import pl.patrykkawula.carrental.client.address.model.Address;
import pl.patrykkawula.carrental.client.address.service.AddressService;
import pl.patrykkawula.carrental.client.dtos.ClientDto;
import pl.patrykkawula.carrental.client.exceptions.ClientException;
import pl.patrykkawula.carrental.client.model.Client;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AddressService addressService;
    private final static Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    public ClientServiceImpl(ClientRepository clientRepository, AddressService addressService) {
        this.clientRepository = clientRepository;
        this.addressService = addressService;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = map(clientDto);
        Client savedClient = clientRepository.save(client);
        log.info("Saved new car with id : {}", savedClient.getId());
        return map(savedClient);


//        Client client = map(clientDto);
//        client.setAddress(null);
//        clientRepository.save(client);
//        client.setAddress(clientDto.address());
//        clientRepository.save(client);
//        log.info("Saved new client with id : {}", client.getId());
//        return clientDto;
    }

    @Override
    @Transactional
    public ClientDto update(Long clientId, ClientDto clientDto) {
        ClientDto updatedClient = clientRepository.findById(clientId)
                .map(client -> updateClient(client, clientDto))
                .map(this::map)
                .orElseThrow(() -> new ClientException(clientId, ClientException.Type.NOT_FOUND));
        log.info("Update client with id: {} body: {}", clientId, updatedClient);
        return updatedClient;
    }

    private Client updateClient(Client client, ClientDto clientDto) {
        client.setFirstName(clientDto.firstName());
        client.setLastName(clientDto.lastName());
        client.setEmail(clientDto.email());
        client.setPhoneNumber(clientDto.phoneNumber());
        client.setBankAccount(clientDto.bankAccount());
        client.setDateOfBirth(clientDto.dateOfBirth());
        client.setDrivingLicenseNumber(clientDto.drivingLicenseNumber());
        client.setAddress(updateClientAddress(client.getId(), clientDto));
        return client;
    }

    private Address updateClientAddress(Long id, ClientDto clientDto) {
        AddressDto updateAddress = addressService.update(id, clientDto.addressDto());
        return map(updateAddress);
    }

    @Override
    public ClientDto delete(Long clientId) {
        Client clientToDelete = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientException(clientId, ClientException.Type.NOT_FOUND));
        clientRepository.delete(clientToDelete);
        log.info("Delete client with id: {}", clientId);
        return map(clientToDelete);
    }

    @Override
    public ClientDto get(Long clientId) {
        return clientRepository.findById(clientId)
                .map(this::map)
                .orElseThrow(() -> new ClientException(clientId, ClientException.Type.NOT_FOUND));
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
                client.getDrivingLicenseNumber(), client.getDateOfBirth(), client.getBankAccount(), map(client.getAddress()));
    }

    private Client map(ClientDto clientDto) {
        return new Client(clientDto.firstName(), clientDto.lastName(), clientDto.email(), clientDto.phoneNumber(),
                clientDto.bankAccount(), clientDto.dateOfBirth(), clientDto.drivingLicenseNumber(), map(clientDto.addressDto()));
    }

    private Address map(AddressDto addressDto) {
        return new Address(addressDto.country(), addressDto.city(), addressDto.zipCode(), addressDto.street(), addressDto.buildingNumber());
    }

    private AddressDto map(Address address) {
        return new AddressDto(address.getCountry(), address.getCity(), address.getZipCode(), address.getStreet(), address.getBuildingNumber());
    }
}
