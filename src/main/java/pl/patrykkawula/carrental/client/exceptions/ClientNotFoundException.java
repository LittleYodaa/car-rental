package pl.patrykkawula.carrental.client.exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super("Brak wyszukiwanego klienta");
    }
}
