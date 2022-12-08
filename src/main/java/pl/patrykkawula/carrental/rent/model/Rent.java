package pl.patrykkawula.carrental.rent.model;

import jakarta.persistence.*;
import pl.patrykkawula.carrental.car.model.Car;
import pl.patrykkawula.carrental.client.model.Client;

import java.time.LocalDateTime;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client customer;
    @ManyToOne
    private Car car;
    private LocalDateTime from;
    private LocalDateTime to;
    private String placeOfRent;
    private String getPlaceOfReturn;
    private Double price;

}
