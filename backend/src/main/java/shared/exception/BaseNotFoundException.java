package shared.exception;

public abstract class BaseNotFoundException extends RuntimeException {
    protected BaseNotFoundException(String message) {
        super(message);
    }
}
