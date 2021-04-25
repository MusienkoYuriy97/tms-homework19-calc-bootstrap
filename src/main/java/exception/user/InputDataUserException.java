package exception.user;

public class InputDataUserException extends UserException {
    public InputDataUserException() {
    }

    public InputDataUserException(String message) {
        super(message);
    }

    public InputDataUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
