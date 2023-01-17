package pl.patrykkawula.carrental.car.service;

import jakarta.transaction.Transactional;
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
import java.util.List;

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
//      given
        CarDto carToSave = new CarDto("testBrand", "testModel", new Engine(150, 100, EngineType.PETROL), Gearbox.AUTOMATIC, 100.00, "12345",
                Year.of(2010), CarType.LIMOUSINE, CarSegment.D, 5);

//      when
        final CarDto savedCar = underTest.save(carToSave);

//      then
        Assertions.assertEquals(5, carRepository.findAll().get(0).getSeats());
        Assertions.assertEquals(5, savedCar.seats());
        Assertions.assertEquals(1, carRepository.findAll().size());
    }

    @Test
    void shouldUpdateCar1ToCar2() {
        //given
        Car carToSave1 = new Car("testBrand1", "testModel1", new Engine(150, 100, EngineType.PETROL), Gearbox.AUTOMATIC, 100.00, "12345",
                Year.of(2010), CarType.LIMOUSINE, CarSegment.D, 5);
        CarDto carToSave2 = new CarDto("testBrand2", "testModel2", new Engine(150, 100, EngineType.PETROL), Gearbox.AUTOMATIC, 100.00, "12345",
                Year.of(2010), CarType.LIMOUSINE, CarSegment.D, 4);
        carRepository.save(carToSave1);

        //when
        underTest.update(carToSave1.getId(), carToSave2);

        //then
        Assertions.assertEquals(4, carRepository.findAll().get(0).getSeats());
    }

    @Test
    void shouldDeleteCar() {
        //given
        Car carToSave = new Car("testBrand", "testModel", new Engine(150, 100, EngineType.PETROL), Gearbox.AUTOMATIC, 100.00, "12345",
                Year.of(2010), CarType.LIMOUSINE, CarSegment.D, 5);
        Car savedCar = carRepository.save(carToSave);

        //when
        underTest.delete(savedCar.getId());

        //then
        Assertions.assertEquals(0, carRepository.findAll().size());
    }

    @Test
    void shouldReturnCar() {
        //given
        Car carToSave = new Car("testBrand", "testModel", new Engine(150, 100, EngineType.PETROL), Gearbox.AUTOMATIC, 100.00, "12345",
                Year.of(2010), CarType.LIMOUSINE, CarSegment.D, 5);
        carRepository.save(carToSave);

        //when
        CarDto returnCar = underTest.get(carToSave.getId());

        //then
        Assertions.assertEquals("12345", returnCar.vin());
        Assertions.assertEquals(5, returnCar.seats());
    }

    @Test
    void shouldReturnListOfTwoCars() {
        //given
        Car carToSave1 = new Car("testBrand1", "testModel1", new Engine(150, 100, EngineType.PETROL), Gearbox.AUTOMATIC, 100.00, "12345",
                Year.of(2010), CarType.LIMOUSINE, CarSegment.D, 5);
        Car carToSave2 = new Car("testBrand2", "testModel2", new Engine(150, 100, EngineType.PETROL), Gearbox.AUTOMATIC, 100.00, "12345",
                Year.of(2010), CarType.LIMOUSINE, CarSegment.D, 5);
        carRepository.save(carToSave1);
        carRepository.save(carToSave2);

        //when
        List<CarDto> carList = underTest.getAll();

        //then
        Assertions.assertEquals(carRepository.findAll().size(), carList.size());
        Assertions.assertEquals("testModel2", carToSave2.getModel());
    }
}