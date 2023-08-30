// Claire Lindstrom CMSC350: Custom exception for expression conversion issues.

package exceptions;

// Our custom exception class for handling conversion errors.
public class ExpressionConversionException extends Exception {

    // Default constructor: uses a generic error message.
    public ExpressionConversionException() {
        super("Oops! Something went wrong with the expression conversion.");
    }

    // Constructor with a custom message: allows for more specific error details.
    public ExpressionConversionException(String message) {
        super(message);
    }
}
