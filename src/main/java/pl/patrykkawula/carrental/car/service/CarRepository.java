package pl.patrykkawula.carrental.car.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.patrykkawula.carrental.car.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
}
