package pl.patrykkawula.carrental.client.address.exceptions;

public class AddressException extends RuntimeException {
    public final Type type;

    public AddressException(Long id, Type type) {
        super("Address with id: " + id);
        this.type = type;
    }

    public enum Type {
        NOT_FOUND,
        ALREADY_EXISTS
    }
}
