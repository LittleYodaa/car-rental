package pl.patrykkawula.carrental.service;

import pl.patrykkawula.carrental.api.client.CreateClientRequest;
import pl.patrykkawula.carrental.api.client.ClientResponse;
import pl.patrykkawula.carrental.api.client.UpdateClientRequest;

public interface ClientService {
  ClientResponse create(CreateClientRequest request);
  ClientResponse update(UpdateClientRequest request);
  void delete(Long customerId);
  ClientResponse get(Long customerId);
}
