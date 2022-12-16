package pl.patrykkawula.carrental.car.exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
        super("Brak wyszukiwanego samochodu");
    }
}
