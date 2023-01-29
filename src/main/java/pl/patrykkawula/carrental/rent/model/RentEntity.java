package pl.patrykkawula.carrental.rent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.patrykkawula.carrental.car.model.Car;
import pl.patrykkawula.carrental.client.model.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent")
public class RentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    private LocalDateTime pickupDateTime;
    private LocalDateTime returnDateTime;
    private String placeOfRent;
    private String placeOfReturn;
    private BigDecimal price;

    public RentEntity() {
    }

    public RentEntity(final Client client, final Car car, final LocalDateTime pickupDateTime, final LocalDateTime returnDateTime,
        final String placeOfRent,
        final String placeOfReturn, final BigDecimal price) {
        this.client = client;
        this.car = car;
        this.pickupDateTime = pickupDateTime;
        this.returnDateTime = returnDateTime;
        this.placeOfRent = placeOfRent;
        this.placeOfReturn = placeOfReturn;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getPickupDateTime() {
        return pickupDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public String getPlaceOfRent() {
        return placeOfRent;
    }

    public String getPlaceOfReturn() {
        return placeOfReturn;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
