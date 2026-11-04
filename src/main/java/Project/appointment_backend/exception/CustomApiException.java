package Project.appointment_backend.exception;

import lombok.Getter;

@Getter
public class CustomApiException extends RuntimeException {
    private final ErrorCode errorCode;
    public CustomApiException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}

