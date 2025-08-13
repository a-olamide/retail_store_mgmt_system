package org.olamide.retailstoremgmtsystem.advice;

import org.olamide.retailstoremgmtsystem.api.ApiResponse;
import org.olamide.retailstoremgmtsystem.enums.ErrorCode;
import org.olamide.retailstoremgmtsystem.exception.CategoryNotFoundException;
import org.olamide.retailstoremgmtsystem.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

public class GlobalExceptionHandler {
    //404 fallback
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleProductNotFoundException(ProductNotFoundException ex, ServletWebRequest req) {
        var uri = req.getRequest().getRequestURI();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ApiResponse.error(HttpStatus.NOT_FOUND, ErrorCode.PRODUCT_NOT_FOUND, ex.getMessage(), uri));
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleCategoryNotFoundException(CategoryNotFoundException ex, ServletWebRequest req) {
        var uri = req.getRequest().getRequestURI();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ApiResponse.error(HttpStatus.NOT_FOUND, ErrorCode.CATEGORY_NOT_FOUND, ex.getMessage(), uri));
    }
    // 500 fallback
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleUnhandled(Exception ex, ServletWebRequest req) throws Exception {
        var uri = req.getRequest().getRequestURI();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.UNEXPECTED_ERROR, "Unexpected error", uri));
    }
}
