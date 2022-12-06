package pl.patrykkawula.carrental.car.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Engine {
    private Long id;
    private int power;
    private double displacement;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    public Engine() {
    }

    public Engine(int power, double displacement, EngineType engineType) {
        this.power = power;
        this.displacement = displacement;
        this.engineType = engineType;
    }
}
