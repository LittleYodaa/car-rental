package pl.patrykkawula.carrental.client.service;

import org.springframework.data.repository.CrudRepository;
import pl.patrykkawula.carrental.client.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
