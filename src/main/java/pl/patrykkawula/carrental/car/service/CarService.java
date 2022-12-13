package pl.patrykkawula.carrental.car.service;

import pl.patrykkawula.carrental.api.car.CreateCarRequest;
import pl.patrykkawula.carrental.api.car.CarResponse;
import pl.patrykkawula.carrental.api.car.UpdateCarRequest;
import pl.patrykkawula.carrental.car.model.Car;

import java.util.List;

public interface CarService {
    Car create(Car car);

    Car update(Long carId);

    void delete(Long carId);

    Car get(Long carId);

    List<Car> get();
}
