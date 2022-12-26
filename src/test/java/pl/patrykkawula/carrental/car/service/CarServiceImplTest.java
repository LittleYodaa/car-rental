package pl.patrykkawula.carrental.car.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.patrykkawula.carrental.car.dtos.CarDto;
import pl.patrykkawula.carrental.car.model.Car;
import pl.patrykkawula.carrental.car.model.CarSegment;
import pl.patrykkawula.carrental.car.model.CarType;
import pl.patrykkawula.carrental.car.model.Engine;
import pl.patrykkawula.carrental.car.model.EngineType;
import pl.patrykkawula.carrental.car.model.Gearbox;

import java.time.Year;

@SpringBootTest
@ActiveProfiles("test")
class CarServiceImplTest {

  @Autowired
  CarService underTest;

  @Autowired
  CarRepository carRepository;

  @AfterEach
  void afterEach() {
    carRepository.deleteAll();
  }

  @Test
  void shouldSaveNewCar() {
//        given:
    CarDto carToSave = new CarDto("testBrand", "testModel", new Engine(150, 100, EngineType.PETROL), Gearbox.AUTOMATIC, 100.00, "12345",
        Year.of(2010), CarType.LIMOUSINE, CarSegment.D, 5);

//        when:
    final CarDto savedCar = underTest.save(carToSave);

//        then:
    //  czy w zapisanym aucie zgadza się liczba miejsc
    Assertions.assertEquals(5, carRepository.findAll().get(0).getSeats());
    //  czy w zwracanym dto zgadza się liczba miejsc
    Assertions.assertEquals(5, savedCar.seats());
    //  czy w repo jest jedno auto
    Assertions.assertEquals(1, carRepository.findAll().size());
  }

  @Test
  void shouldDeleteCar() {
    //        given:
    Car carToSave = new Car("testBrand", "testModel", new Engine(150, 100, EngineType.PETROL), Gearbox.AUTOMATIC, 100.00, "12345",
        Year.of(2010), CarType.LIMOUSINE, CarSegment.D, 5);
    carRepository.save(carToSave);

//        when:
    underTest.delete(1L);

//    then:
    Assertions.assertEquals(0, carRepository.findAll().size());
  }
}