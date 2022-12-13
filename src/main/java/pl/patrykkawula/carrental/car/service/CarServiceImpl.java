package pl.patrykkawula.carrental.car.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.car.exceptions.CarNotFoundException;
import pl.patrykkawula.carrental.car.model.*;
import pl.patrykkawula.carrental.car.dtos.CarDto;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(CarDto carDto) {
        Car car = carDtoToCarMapper(carDto);
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public CarDto update(Long carId, CarDto carDto) {
        Car car = carRepository
                .findById(carId)
                .orElseThrow(CarNotFoundException::new);
        return carToCarDtoMapper(updateCar(car, carDto));
    }

    @Override
    public void delete(Long carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public CarDto get(Long carId) {
        Car car = carRepository
                .findById(carId)
                .orElseThrow(CarNotFoundException::new);
        return carToCarDtoMapper(car);
    }

    @Override
    public List<CarDto> get() {
        return carRepository.findAll().stream().map(this::carToCarDtoMapper).toList();

    }

    private CarDto carToCarDtoMapper(Car car) {
        return new CarDto(car.getBrand(), car.getModel(), car.getEngine(), car.getGearbox(), car.getBasePrice(),
                car.getVin(), car.getProductionYear(), car.getCarType(), car.getCarSegment(), car.getSeats());
    }

    private Car carDtoToCarMapper(CarDto carDto) {
        return new Car(carDto.getBrand(), carDto.getModel(), carDto.getEngine(), carDto.getGearbox(), carDto.getBasePrice(),
                carDto.getVin(), carDto.getProductionYear(), carDto.getCarType(), carDto.getCarSegment(), carDto.getSeats());
    }

    private Car updateCar(Car car, CarDto carDto) {
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setEngine(carDto.getEngine());
        car.setGearbox(carDto.getGearbox());
        car.setBasePrice(carDto.getBasePrice());
        car.setVin(carDto.getVin());
        car.setProductionYear(carDto.getProductionYear());
        car.setCarType(carDto.getCarType());
        car.setCarSegment(carDto.getCarSegment());
        car.setSeats(carDto.getSeats());
        return car;
    }
}
