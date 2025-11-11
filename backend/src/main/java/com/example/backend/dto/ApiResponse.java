package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private HttpStatus httpStatus;
    private String message;
    
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(data, HttpStatus.OK, message);
    }
    
    public static <T> ApiResponse<T> created(T data, String message) {
        return new ApiResponse<>(data, HttpStatus.CREATED, message);
    }
    
    public static <T> ApiResponse<T> accepted(String message) {
        return new ApiResponse<>(null, HttpStatus.ACCEPTED, message);
    }
    
    public static <T> ApiResponse<T> notFound(String message) {
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND, message);
    }
    
    public static <T> ApiResponse<T> badRequest(String message) {
        return new ApiResponse<>(null, HttpStatus.BAD_REQUEST, message);
    }
}