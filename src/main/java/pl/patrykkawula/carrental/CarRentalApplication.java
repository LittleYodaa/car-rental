package pl.patrykkawula.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.patrykkawula.carrental.car.dtos.CarDto;
import pl.patrykkawula.carrental.car.model.*;
import pl.patrykkawula.carrental.car.service.CarService;
import pl.patrykkawula.carrental.car.service.CarServiceImpl;

import java.time.Year;

@SpringBootApplication
public class CarRentalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CarRentalApplication.class, args);
        CarService carService = context.getBean(CarService.class);
        Engine engine1 = new Engine(280, 1995, EngineType.PETROL);
        Engine engine2 = new Engine(197, 2998, EngineType.DIESEL);
        Engine engine3 = new Engine(100, 1397, EngineType.PETROL);

        CarDto car1 = new CarDto("Alfa Romeo", "Giulia", engine1, Gearbox.AUTOMATIC, 399.99, "ZARPAH7HN84753", Year.of(2017), CarType.LIMOUSINE, CarSegment.D, 5);
        CarDto car2 = new CarDto("BMW", "series 3", engine2, Gearbox.MANUAL, 119.99, "XDKJFHSH7HN84753", Year.of(2008), CarType.STATION_WAGON, CarSegment.D, 5);
        CarDto car3 = new CarDto("Opel", "Adam", engine3, Gearbox.MANUAL, 99.99, "ZARJKD78HN84753", Year.of(2012), CarType.HATCHBACK, CarSegment.A, 4);

        CarDto carDto1 = new CarDto("BMW", "series 3", engine2, Gearbox.MANUAL, 119.99, "XDKJFHSH7HN84753", Year.of(2008), CarType.STATION_WAGON, CarSegment.D, 6);

        carService.save(car1);
        carService.save(car2);
        carService.save(car3);

        carService.delete(3L);

        CarDto carToPrint = carService.get(2L);
        System.out.println(carToPrint);

        carService.update(2L, carDto1);

        for (CarDto carDto : carService.get()) {
            System.out.println(carDto);
        }
    }

}
