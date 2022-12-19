package pl.patrykkawula.carrental.client.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.patrykkawula.carrental.client.dtos.ClientDto;
import pl.patrykkawula.carrental.client.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAll();
}