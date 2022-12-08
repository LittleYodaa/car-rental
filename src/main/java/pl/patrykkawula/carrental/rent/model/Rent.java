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
    private Client client;
    @ManyToOne
    private Car car;
    private LocalDateTime from;
    private LocalDateTime to;
    private String placeOfRent;
    private String getPlaceOfReturn;
    private Double price;

    public Rent() {
    }

    public Rent(Client client, Car car, LocalDateTime from, LocalDateTime to, String placeOfRent,
                String getPlaceOfReturn, Double price) {
        this.client = client;
        this.car = car;
        this.from = from;
        this.to = to;
        this.placeOfRent = placeOfRent;
        this.getPlaceOfReturn = getPlaceOfReturn;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public String getPlaceOfRent() {
        return placeOfRent;
    }

    public void setPlaceOfRent(String placeOfRent) {
        this.placeOfRent = placeOfRent;
    }

    public String getGetPlaceOfReturn() {
        return getPlaceOfReturn;
    }

    public void setGetPlaceOfReturn(String getPlaceOfReturn) {
        this.getPlaceOfReturn = getPlaceOfReturn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", client=" + client +
                ", car=" + car +
                ", from=" + from +
                ", to=" + to +
                ", placeOfRent='" + placeOfRent + '\'' +
                ", getPlaceOfReturn='" + getPlaceOfReturn + '\'' +
                ", price=" + price +
                '}';
    }
}
