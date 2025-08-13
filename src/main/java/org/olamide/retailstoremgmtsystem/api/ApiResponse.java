package org.olamide.retailstoremgmtsystem.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.olamide.retailstoremgmtsystem.enums.ErrorCode;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
        int httpStatus,          // e.g., 200, 201, 404
        String httpStatusText,   // e.g., "OK", "CREATED", "NOT_FOUND"
        T data,                  // payload for success; null for errors
        ErrorCode errorCode,     // enum; null for success
        String errorMessage,     // human-friendly; null for success
        String path,             // request path for diagnostics
        OffsetDateTime timestamp
) {
    public static <T> ApiResponse<T> success(HttpStatus status, T data) {
        return new ApiResponse<>(
                status.value(),
                status.name(),
                data,
                null,
                null,
                null,
                OffsetDateTime.now()
        );
    }
    public static <T> ApiResponse<T> ok(T data) {
        return success(HttpStatus.OK, data);
    }
    public static <T> ApiResponse<T> created(T data) {
        return success(HttpStatus.CREATED, data);
    }
    public static <T> ApiResponse<T> badRequest() {
        return success(HttpStatus.BAD_REQUEST, null);
    }
    public static <T> ApiResponse<T> unauthorized() {
        return success(HttpStatus.UNAUTHORIZED, null);
    }
    public static <T> ApiResponse<T> of(HttpStatus status, ErrorCode errorCode, String errorMessage, T data, String path) {
        return new ApiResponse<>(
                status.value(),
                status.name(),
                data,
                errorCode,
                errorMessage,
                path,
                OffsetDateTime.now()
        );
    }
    public static ApiResponse<Void> error(HttpStatus status, ErrorCode errorCode, String errorMessage, String path) {
        return new ApiResponse<>(
                status.value(),
                status.name(),
                null,
                errorCode,
                errorMessage,
                path,
                OffsetDateTime.now()
        );
    }


}