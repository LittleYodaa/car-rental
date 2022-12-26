package pl.patrykkawula.carrental.car.service;

import pl.patrykkawula.carrental.car.model.*;
import pl.patrykkawula.carrental.car.dtos.CarDto;

import java.util.List;

public interface CarService {
    CarDto save(CarDto cardto);

    CarDto update(Long carId, CarDto carDto);

    void delete(Long carId);

    CarDto get(Long carId);

    List<CarDto> getAll();
}
