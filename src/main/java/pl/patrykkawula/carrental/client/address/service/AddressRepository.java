package pl.patrykkawula.carrental.client.address.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykkawula.carrental.client.address.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
