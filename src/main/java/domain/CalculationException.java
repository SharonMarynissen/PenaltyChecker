package domain;

/**
 * Exception that is thrown when something went wrong during calculations
 */
public class CalculationException extends Exception {
    public CalculationException(String message) {
        super(message);
    }

    public CalculationException(String message, Throwable cause) {
        super(message, cause);
    }
}
