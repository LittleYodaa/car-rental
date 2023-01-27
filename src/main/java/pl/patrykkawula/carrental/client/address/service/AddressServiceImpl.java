package pl.patrykkawula.carrental.client.address.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.client.address.dtos.AddressDto;
import pl.patrykkawula.carrental.client.address.exceptions.AddressException;
import pl.patrykkawula.carrental.client.address.model.Address;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private static final Logger log = LoggerFactory.getLogger(Address.class);

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        Address address = map(addressDto);
        addressRepository.save(address);
        log.info("Saved new address with id : {}", address.getId());
        return addressDto;
    }

    @Override
    @Transactional
    public AddressDto update(Long id, AddressDto addressDto) {
        AddressDto updatedAddress = addressRepository.findById(id)
                .map(address -> updateAddress(address, addressDto))
                .map(this::map)
                .orElseThrow(() -> new AddressException(id, AddressException.Type.NOT_FOUND));
        log.info("Update address with id: {} body: {}", id, updatedAddress);
        return updatedAddress;
    }

    @Override
    public AddressDto delete(Long id) {
        // todo przy delete wystarczy addressRepository.deleteById(). Nie trzeba rzucać wyjątku ani zwracać dto,
        // todo bo potem w kontrolerze obojetnie czy cos zostanie usuniete czy nie zwraca sie chyba 'non content' jesli dobrze pamietam
        Address addressToDelete = addressRepository.findById(id)
                .orElseThrow(() -> new AddressException(id, AddressException.Type.NOT_FOUND));
        addressRepository.delete(addressToDelete);;
        log.info("Delete address with id: {}", id);
        return map(addressToDelete);
    }

    @Override
    public AddressDto get(Long id) {
        return addressRepository.findById(id)
                .map(this::map)
                .orElseThrow(() -> new AddressException(id, AddressException.Type.NOT_FOUND));
    }

    @Override
    public List<AddressDto> getAll() {
        return addressRepository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private Address map(AddressDto addressDto) {
        return new Address(addressDto.country(), addressDto.city(), addressDto.zipCode(), addressDto.street(),
                addressDto.buildingNumber());
    }

    private AddressDto map(Address address) {
        return new AddressDto(address.getCountry(), address.getCity(), address.getZipCode(), address.getStreet(),
                address.getBuildingNumber());
    }

    private Address updateAddress(Address address, AddressDto addressDto) {
        address.setCountry(addressDto.country());
        address.setCity(addressDto.city());
        address.setZipCode(addressDto.zipCode());
        address.setStreet(addressDto.street());
        address.setBuildingNumber(addressDto.buildingNumber());
        return address;
    }
}
