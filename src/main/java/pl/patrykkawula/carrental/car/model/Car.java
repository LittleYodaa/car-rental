package pl.patrykkawula.carrental.car.model;

import jakarta.persistence.*;
import pl.patrykkawula.carrental.rent.model.Rent;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    @Embedded
    private Engine engine;
    @Enumerated(EnumType.STRING)
    private Gearbox gearbox;
    private Double basePrice;
    private String vin;
    private Year productionYear;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    @Enumerated(EnumType.STRING)
    private CarSegment carSegment;
    private int seats;
    @OneToMany(mappedBy = "car")
    List<Rent> rentList = new ArrayList<>();

    public Car() {
    }


}


