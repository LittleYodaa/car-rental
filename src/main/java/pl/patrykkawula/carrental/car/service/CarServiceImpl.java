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
        Car car = map(carDto);
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public CarDto update(Long carId, CarDto carDto) {
        return carRepository.findById(carId)
                .map(car -> updateCar(car, carDto))
                .map(this::map)
                .orElseThrow(CarNotFoundException::new);
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
        return map(car);
    }

    @Override
    public List<CarDto> get() {
        return carRepository.findAll()
                .stream()
                .map(this::map)
                .toList();

    }

    private CarDto map(Car car) {
        return new CarDto(car.getBrand(), car.getModel(), car.getEngine(), car.getGearbox(), car.getBasePrice(),
                car.getVin(), car.getProductionYear(), car.getCarType(), car.getCarSegment(), car.getSeats());
    }

    private Car map(CarDto carDto) {
        return new Car(carDto.brand(), carDto.model(), carDto.engine(), carDto.gearbox(), carDto.basePrice(),
                carDto.vin(), carDto.productionYear(), carDto.carType(), carDto.carSegment(), carDto.seats());
    }

    private Car updateCar(Car car, CarDto carDto) {
        car.setBrand(carDto.brand());
        car.setModel(carDto.model());
        car.setEngine(carDto.engine());
        car.setGearbox(carDto.gearbox());
        car.setBasePrice(carDto.basePrice());
        car.setVin(carDto.vin());
        car.setProductionYear(carDto.productionYear());
        car.setCarType(carDto.carType());
        car.setCarSegment(carDto.carSegment());
        car.setSeats(carDto.seats());
        return car;
    }
}
