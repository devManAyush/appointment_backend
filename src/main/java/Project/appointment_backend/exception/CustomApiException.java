package Project.appointment_backend.exception;

public class CustomApiException extends RuntimeException {
    private final ErrorCode errorCode;
    public CustomApiException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    public ErrorCode getErrorCode() {
        return errorCode;
    }
    }
}
