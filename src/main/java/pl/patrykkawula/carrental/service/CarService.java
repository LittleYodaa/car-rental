package pl.patrykkawula.carrental.service;

import pl.patrykkawula.carrental.api.car.CreateCarRequest;
import pl.patrykkawula.carrental.api.car.CarResponse;
import pl.patrykkawula.carrental.api.car.UpdateCarRequest;

import java.util.List;

public interface CarService {
  CarResponse create(CreateCarRequest request);
  CarResponse update(UpdateCarRequest request);
  void delete(Long carId);
  CarResponse get(Long carId);
  List<CarResponse> get();
}
