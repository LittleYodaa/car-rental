package pl.patrykkawula.carrental.car.exceptions;

public class CarException extends RuntimeException {

    private final Type type;
    public CarException(Long id, Type type) {
        super("Car with id: " + id);
        this.type = type;
    }

    public enum Type {
        NOT_FOUND,
        ALREADY_EXISTS
    }
}
