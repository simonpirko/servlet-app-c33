package by.tms.service.exceptions;

public class DouplicateUserException extends Exception {
    @Override
    public String getMessage() {
        return "We have this user";
    }

    public DouplicateUserException() {
        super();
    }

    public DouplicateUserException(String message) {
        super(message);
    }

    public DouplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DouplicateUserException(Throwable cause) {
        super(cause);
    }

    protected DouplicateUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
