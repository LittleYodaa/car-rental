package pl.patrykkawula.carrental.car.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.patrykkawula.carrental.car.model.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfListOfCarFromDatabaseIsEqualToListInMethod() {
        //given
        Engine engine = new Engine(280, 1995, EngineType.PETROL);
        Car car = new Car("Alfa Romeo", "Giulia", engine, Gearbox.AUTOMATIC, 399.99,
                "ZARPAH7HN84753", Year.of(2017), CarType.LIMOUSINE, CarSegment.D, 5);
        underTest.save(car);

        List<Car> expResult = new ArrayList<>();
        expResult.add(car);

        //when
        List<Car> result = underTest.findAll();

        //then
        assertEquals(expResult, result);
    }
}