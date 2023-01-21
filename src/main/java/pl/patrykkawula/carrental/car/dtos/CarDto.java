package pl.patrykkawula.carrental.car.dtos;

import pl.patrykkawula.carrental.car.model.*;

import java.time.Year;

public record CarDto(Long id,
                     String brand,
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
