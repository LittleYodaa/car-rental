package pl.patrykkawula.carrental.client.exceptions;

public class ClientException extends RuntimeException {
    private final Type type;

    public ClientException(Long id, Type type) {
        super("Client with id: " + id);
        this.type = type;
    }

    public enum Type {
        NOT_FOUND,
        ALREADY_EXISTS
    }
}
