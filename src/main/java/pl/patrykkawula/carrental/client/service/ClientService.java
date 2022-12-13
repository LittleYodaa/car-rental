package pl.patrykkawula.carrental.client.service;

import pl.patrykkawula.carrental.api.client.CreateClientRequest;
import pl.patrykkawula.carrental.api.client.ClientResponse;
import pl.patrykkawula.carrental.api.client.UpdateClientRequest;
import pl.patrykkawula.carrental.client.model.Client;

public interface ClientService {
  Client create(Client client);
  Client update(Long clientId);
  void delete(Long clientId);
  Client get(Long clientId);
}
