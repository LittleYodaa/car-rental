package pl.patrykkawula.carrental.client.address.service;

import pl.patrykkawula.carrental.client.address.dtos.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto save(AddressDto addressDto);

    AddressDto update(Long id, AddressDto addressDto);

    AddressDto remove(Long id);

    AddressDto get(Long id);

    List<AddressDto> getAll();
}
