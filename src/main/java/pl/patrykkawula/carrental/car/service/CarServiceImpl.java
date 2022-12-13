package pl.patrykkawula.carrental.car.service;

import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.car.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car create(Car car) {
        return null;
    }

    @Override
    public Car update(Long carId) {
        return null;
    }

    @Override
    public void delete(Long carId) {

    }

    @Override
    public Car get(Long carId) {
        return null;
    }

    @Override
    public List<Car> get() {
        return null;
    }
}
