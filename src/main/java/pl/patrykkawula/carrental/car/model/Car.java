package pl.patrykkawula.carrental.car.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    @Embedded
    private Engine engine;
    private Gearbox gearbox;
    private Double basePrice;
    private String vin;
    //TODO finish class, chceck @Embadded and @Enumerated annotation
}


