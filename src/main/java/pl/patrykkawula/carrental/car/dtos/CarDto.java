package pl.patrykkawula.carrental.car.dtos;

import pl.patrykkawula.carrental.car.model.CarSegment;
import pl.patrykkawula.carrental.car.model.CarType;
import pl.patrykkawula.carrental.car.model.Engine;
import pl.patrykkawula.carrental.car.model.Gearbox;

import java.time.Year;

public record CarDto(String brand,
                     String model,
                     Engine engine,
                     Gearbox gearbox,
                     Double basePrice,
                     String vin,
                     Year productionYear,
                     CarType carType,
                     CarSegment carSegment,
                     int seats) {
}
