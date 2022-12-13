package pl.patrykkawula.carrental.car.model;

import jakarta.persistence.*;

import java.time.Year;

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
//    @OneToMany(mappedBy = "car")
//    List<Rent> rentList = new ArrayList<>();

    public Car() {
    }

    public Car(String brand, String model, Engine engine, Gearbox gearbox, Double basePrice, String vin, Year productionYear, CarType carType, CarSegment carSegment, int seats) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.gearbox = gearbox;
        this.basePrice = basePrice;
        this.vin = vin;
        this.productionYear = productionYear;
        this.carType = carType;
        this.carSegment = carSegment;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Year getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Year productionYear) {
        this.productionYear = productionYear;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public CarSegment getCarSegment() {
        return carSegment;
    }

    public void setCarSegment(CarSegment carSegment) {
        this.carSegment = carSegment;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}


