package pl.patrykkawula.carrental.client.service;

import pl.patrykkawula.carrental.client.dtos.ClientDto;

import java.util.List;

public interface ClientService {
  ClientDto save(ClientDto clientDto);
  ClientDto update(Long clientId, ClientDto clientDto);
  ClientDto delete(Long clientId);
  ClientDto get(Long clientId);
  List<ClientDto> getAll();
}
