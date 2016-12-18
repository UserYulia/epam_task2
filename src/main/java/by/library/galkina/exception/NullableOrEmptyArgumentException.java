package by.library.galkina.exception;


public class NullableOrEmptyArgumentException extends Exception {
    public NullableOrEmptyArgumentException() {
    }

    public NullableOrEmptyArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullableOrEmptyArgumentException(String message) {
        super(message);
    }

    public NullableOrEmptyArgumentException(Throwable cause) {
        super(cause);
    }
}
