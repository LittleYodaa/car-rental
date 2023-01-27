package pl.patrykkawula.carrental.car.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.patrykkawula.carrental.car.dtos.CarDto;
import pl.patrykkawula.carrental.car.exceptions.CarException;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody CarDto car) {
        try {
            carService.update(id, car);
            return ResponseEntity.ok().build();
        } catch (CarException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        try {
            CarDto foundCar = carService.get(id);
            return ResponseEntity.ok(foundCar);
        } catch (CarException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getCars(@RequestParam(required = false) String brand) {

        /*
        // TODO
        Fajna jest metoda Objects.isNull() zamiast sprawdzac przy pomocy '=='
        całość można tak zastąpić:
        List<CarDto> cars = Objects.isNull(brand) ? carService.getAll() : carService.getAllByBrand(brand);
        return ResponseEntity.ok(cars);
         */

        if (brand == null) {
            List<CarDto> cars = carService.getAll();
            return ResponseEntity.ok(cars);
        } else {
            List<CarDto> carsByBrand = carService.getAllByBrand(brand);
            return ResponseEntity.ok(carsByBrand);
        }
    }
}
