package pl.patrykkawula.carrental;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.patrykkawula.carrental.car.dtos.CarDto;
import pl.patrykkawula.carrental.car.model.*;
import pl.patrykkawula.carrental.car.service.CarService;
import pl.patrykkawula.carrental.client.address.dtos.AddressDto;
import pl.patrykkawula.carrental.client.dtos.ClientDto;
import pl.patrykkawula.carrental.client.address.model.Address;
import pl.patrykkawula.carrental.client.service.ClientService;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

@SpringBootApplication
public class CarRentalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CarRentalApplication.class, args);
        CarService carService = context.getBean(CarService.class);
        ClientService clientService = context.getBean(ClientService.class);


//        Engine engine1 = new Engine(280, 1995, EngineType.PETROL);
//        Engine engine2 = new Engine(197, 2998, EngineType.DIESEL);
//        Engine engine3 = new Engine(100, 1397, EngineType.PETROL);
//
//        CarDto car1 = new CarDto("Alfa Romeo", "Giulia", engine1, Gearbox.AUTOMATIC, 399.99, "ZARPAH7HN84753", Year.of(2017), CarType.LIMOUSINE, CarSegment.D, 5);
//        CarDto car2 = new CarDto("BMW", "series 3", engine2, Gearbox.MANUAL, 119.99, "XDKJFHSH7HN84753", Year.of(2008), CarType.STATION_WAGON, CarSegment.D, 5);
//        CarDto car3 = new CarDto("Opel", "Adam", engine3, Gearbox.MANUAL, 99.99, "ZARJKD78HN84753", Year.of(2012), CarType.HATCHBACK, CarSegment.A, 4);
//
//        CarDto carDto1 = new CarDto("BMW", "series 3", engine2, Gearbox.MANUAL, 119.99, "XDKJFHSH7HN84753", Year.of(2008), CarType.STATION_WAGON, CarSegment.D, 6);
//
//        carService.save(car1);
//        carService.save(car2);
//        carService.save(car3);
//
//        carService.delete(3L);
//
//        CarDto carToPrint = carService.get(2L);
//        System.out.println(carToPrint);
//
//        carService.update(2L, carDto1);
//
//        for (CarDto carDto : carService.get()) {
//            System.out.println(carDto);
//        }

        AddressDto address1 = new AddressDto("Poland", "Wroc??aw", "34-827", " Wiejska", "7");
        AddressDto address2 = new AddressDto("Poland", "Krak??w", "64-297", "Le??na", "4");
        AddressDto address3 = new AddressDto("Poland", "Gdynia", "81-457", "W??adys??awa 4", "40/3");

        ClientDto client1 = new ClientDto("Ania", "Calik", "anna.calik@wp.pl", "506784567", "4120943700009637", LocalDate.of(1995, Month.AUGUST, 21), "DHE84392", address1);
        ClientDto client2 = new ClientDto("Wojtek", "Koz??owski", "wojtek.kozlowski@o2.pl", "746895123", "4120000045879632", LocalDate.of(2001, Month.FEBRUARY, 4), "ZHS56432", address2);
        ClientDto client3 = new ClientDto("Marta", "Lidzka", "marta.lidzka@gmail.pl", "465782169", "1245978600002156", LocalDate.of(1987, Month.AUGUST, 27), "HYT65732", address3);

        AddressDto updatedAddress = new AddressDto("England", "Dzia??dowo", "34-827", " Wiejska", "7");
        ClientDto clientUpdate2 = new ClientDto("Wojtek", "Kozio??kowski",
                "wojtek.kozolkowski@o2.pl", "746895123", "4120000045879632",
                LocalDate.of(2001, Month.FEBRUARY, 4), "ZHS56432", updatedAddress);

        ClientDto clientUpdate3 = new ClientDto("Wojtek", "Kozio??kowski",
                "wojtek.kozolkowski@o2.pl", "746895123", "4120000045879632",
                LocalDate.of(2001, Month.FEBRUARY, 4), "ZHS56432", address2);


        clientService.save(client1);
        clientService.save(client2);
        clientService.save(client3);

        clientService.update(2L, clientUpdate2);

        clientService.update(2L, clientUpdate3);
    }
}
