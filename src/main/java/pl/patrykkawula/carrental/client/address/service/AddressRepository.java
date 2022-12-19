package pl.patrykkawula.carrental.client.address.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.patrykkawula.carrental.client.address.dtos.AddressDto;
import pl.patrykkawula.carrental.client.address.model.Address;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAll();
}
