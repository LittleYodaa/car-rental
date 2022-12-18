package pl.patrykkawula.carrental.client.service;

import org.springframework.data.repository.CrudRepository;
import pl.patrykkawula.carrental.client.dtos.ClientDto;
import pl.patrykkawula.carrental.client.model.Client;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findAll();
}