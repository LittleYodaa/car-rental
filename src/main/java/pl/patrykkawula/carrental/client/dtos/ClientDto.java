package pl.patrykkawula.carrental.client.dtos;

import pl.patrykkawula.carrental.client.address.dtos.AddressDto;
import pl.patrykkawula.carrental.client.address.model.Address;

import java.time.LocalDate;

public record ClientDto(String firstName,
                        String lastName,
                        String email,
                        String phoneNumber,
                        String bankAccount,
                        LocalDate dateOfBirth,
                        String drivingLicenseNumber,
                        AddressDto addressDto) {
}

//Change Address address to AddressDto addressDto
