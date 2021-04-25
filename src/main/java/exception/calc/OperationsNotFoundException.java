package exception.calc;

public class OperationsNotFoundException extends Exception{
    public OperationsNotFoundException() {
    }

    public OperationsNotFoundException(String message) {
        super(message);
    }

    public OperationsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
