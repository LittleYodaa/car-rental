package pl.patrykkawula.carrental.car.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.patrykkawula.carrental.car.dtos.CarDto;

import java.net.URI;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<CarDto> saveCar(@RequestBody CarDto carDto) {
        CarDto savedCar = carService.save(carDto);
        URI savedCarUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCar.id())
                .toUri();
        return ResponseEntity.created(savedCarUri).body(savedCar);
    }
}
