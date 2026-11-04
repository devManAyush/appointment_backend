package Project.appointment_backend.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND", HttpStatus.NOT_FOUND),
    SLOT_ALREADY_BOOKED("SLOT_ALREADY_BOOKED", HttpStatus.BAD_REQUEST),
    INVALID_INPUT("INVALID_INPUT", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final HttpStatus status;

    ErrorCode(String code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }
    public String getCode() {
        return code;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
