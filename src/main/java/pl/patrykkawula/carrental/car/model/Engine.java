package pl.patrykkawula.carrental.car.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Engine {
    private Integer power;
    private Integer displacement;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    public Engine() {
    }

    public Engine(int power, int displacement, EngineType engineType) {
        this.power = power;
        this.displacement = displacement;
        this.engineType = engineType;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}
