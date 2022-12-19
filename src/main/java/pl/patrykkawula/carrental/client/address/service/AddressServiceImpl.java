package pl.patrykkawula.carrental.client.address.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.client.address.dtos.AddressDto;
import pl.patrykkawula.carrental.client.address.exceptions.AddressException;
import pl.patrykkawula.carrental.client.address.model.Address;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public AddressDto save(AddressDto addressDto) {
        Address address = map(addressDto);
        addressRepository.save(address);
        return addressDto;
    }

    @Override
    @Transactional
    public AddressDto update(Long id, AddressDto addressDto) {
        return addressRepository.findById(id)
                .map(address -> updateAddress(address, addressDto))
                .map(this::map)
                .orElseThrow(() -> new AddressException(id, AddressException.Type.NOT_FOUND));
    }

    @Override
    public AddressDto remove(Long id) {
        Address addressToDelete = addressRepository.findById(id)
                .orElseThrow(() -> new AddressException(id, AddressException.Type.NOT_FOUND));
        addressRepository.delete(addressToDelete);
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
        return new Address(addressDto.country(), addressDto.city(), addressDto.zipCode(), addressDto.street(), addressDto.buildingNumber());
    }

    private AddressDto map(Address address) {
        return new AddressDto(address.getCountry(), address.getCity(), address.getZipCode(), address.getStreet(), address.getBuildingNumber());
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
