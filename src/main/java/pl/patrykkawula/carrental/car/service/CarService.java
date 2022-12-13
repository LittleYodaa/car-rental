package pl.patrykkawula.carrental.car.service;

import pl.patrykkawula.carrental.car.model.*;
import pl.patrykkawula.carrental.car.dtos.CarDto;

import java.util.List;

public interface CarService {
    Car save(Car car);

    CarDto update(Long carId, CarDto carDto);

    void delete(Long carId);

    Car get(Long carId);

    List<CarDto> get();
}
