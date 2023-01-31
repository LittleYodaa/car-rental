package pl.patrykkawula.carrental.client.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.patrykkawula.carrental.client.address.dtos.AddressDto;
import pl.patrykkawula.carrental.client.address.model.Address;
import pl.patrykkawula.carrental.client.dtos.ClientDto;
import pl.patrykkawula.carrental.client.model.Client;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class ClientServiceImplTest {

    @Autowired
    ClientService underTest;
    @Autowired
    ClientRepository clientRepository;


    @AfterEach
    void tearDown() {
        clientRepository.deleteAll();
    }

    @Test
    void shouldSaveNewClient() {
        //given
        AddressDto address1 = new AddressDto("Country1", "City1", "1111", "Street1", "1");
        ClientDto client1 = new ClientDto("Client1", "Client1", "client1@mail.com",
                "123456789", "2222333344445555",
                LocalDate.of(2023, Month.JANUARY, 1), "11223344", address1);

        //when
        underTest.save(client1);

        //then
        assertEquals("Client1", clientRepository.findAll().get(0).getFirstName());
    }

    @Test
    void shouldUpdateClient1ToClient2() {
        //given
        Address address1 = new Address("Country1", "City1", "1111", "Street1", "1");
        AddressDto address2 = new AddressDto("Country1", "City1", "1111", "Street1", "1");

        Client client1 = new Client("Client1", "Client1", "client1@mail.com",
                "123456789", "2222333344445555",
                LocalDate.of(2023, Month.JANUARY, 1), "11223344", address1);
        ClientDto client2 = new ClientDto("Client2", "Client2", "client2@mail.com",
                "123456789", "2222333344445555",
                LocalDate.of(2023, Month.JANUARY, 1), "11223344", address2);

        clientRepository.save(client1);

        //when
        underTest.update(client1.getId(), client2);

        //then
        assertEquals("Client2", clientRepository.findAll().get(0).getFirstName());

    }

    @Test
    void shouldDeleteClient() {
        //given
        Address address1 = new Address("Country1", "City1", "1111", "Street1", "1");
        Client client1 = new Client("Client1", "Client1", "client1@mail.com",
                "123456789", "2222333344445555",
                LocalDate.of(2023, Month.JANUARY, 1), "11223344", address1);

        Client savedClient = clientRepository.save(client1);

        //when
        underTest.delete(savedClient.getId());

        //then
        assertEquals(0, clientRepository.count());
    }

    @Test
    void shouldGetClient() {
        //given
        Address address1 = new Address("Country1", "City1", "1111", "Street1", "1");
        Client client1 = new Client("Client1", "Client1", "client1@mail.com",
                "123456789", "2222333344445555",
                LocalDate.of(2023, Month.JANUARY, 1), "11223344", address1);

        clientRepository.save(client1);

        //when
        underTest.get(client1.getId());

        //then
        assertEquals("Client1", clientRepository.findAll().get(0).getFirstName());
    }

    @Test
    void shouldGetAllClient() {
        //given
        Address address1 = new Address("Country1", "City1", "1111", "Street1", "1");
        Client client1 = new Client("Client1", "Client1", "client1@mail.com",
                "123456789", "2222333344445555",
                LocalDate.of(2023, Month.JANUARY, 1), "11223344", address1);

        clientRepository.save(client1);

        //when
        List<ClientDto> clientList = underTest.getAll();

        //then
        assertEquals(clientList.size(), clientRepository.findAll().size());
    }
}