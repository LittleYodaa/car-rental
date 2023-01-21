package pl.patrykkawula.carrental.car.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.patrykkawula.carrental.car.exceptions.CarException;
import pl.patrykkawula.carrental.car.model.*;
import pl.patrykkawula.carrental.car.dtos.CarDto;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private static final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDto save(CarDto carDto) {
        Car car = map(carDto);
        carRepository.save(car);
        log.info("Saved new car with id : {}", car.getId());
        return carDto;
    }

    @Override
    @Transactional
    public CarDto update(Long id, CarDto carDto) {
        CarDto updatedCar = carRepository.findById(id)
                .map(car -> updateCar(car, carDto))
                .map(this::map)
                .orElseThrow(() -> new CarException(id, CarException.Type.NOT_FOUND));
        log.info("Update car with id: {} body: {}", id, updatedCar);
        return updatedCar;
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
        log.info("Delete car with id: {}", id);
    }

    @Override
    public CarDto get(Long id) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new CarException(id, CarException.Type.NOT_FOUND));
        return map(car);
    }

    @Override
    public List<CarDto> getAll() {
        return carRepository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private CarDto map(Car car) {
        return new CarDto(car.getId(),car.getBrand(), car.getModel(), car.getEngine(), car.getGearbox(), car.getBasePrice(),
                car.getVin(), car.getProductionYear(), car.getCarType(), car.getCarSegment(), car.getSeats());
    }

    private Car map(CarDto carDto) {
        return new Car(carDto.brand(), carDto.model(), new Engine(carDto.engine().getPower(), carDto.engine().getDisplacement(), carDto.engine().getEngineType()), carDto.gearbox(), carDto.basePrice(),
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
