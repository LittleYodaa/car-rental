package pl.patrykkawula.carrental.car.service;

import org.springframework.data.repository.CrudRepository;
import pl.patrykkawula.carrental.car.model.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAll();
}
