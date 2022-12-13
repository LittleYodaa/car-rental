package pl.patrykkawula.carrental.rent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Client client;
//    @ManyToOne
//    @JoinColumn(name = "car_id")
//    private Car car;
//    private Date from;
//    private Date to;
    private String placeOfRent;
    private String getPlaceOfReturn;
    private Double price;

    public Rent() {
    }
}
