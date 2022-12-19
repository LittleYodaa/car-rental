package pl.patrykkawula.carrental.client.address.dtos;

public record AddressDto(String country,
                         String city,
                         String zipCode,
                         String street,
                         String buildingNumber) {
}
