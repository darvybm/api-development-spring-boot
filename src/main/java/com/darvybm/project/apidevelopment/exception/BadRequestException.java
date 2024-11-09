package com.darvybm.project.apidevelopment.exception;

import com.darvybm.project.apidevelopment.utils.response.ApiResponse;
import com.darvybm.project.apidevelopment.utils.response.CustResponseBuilder;
import lombok.Getter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ResponseEntity<ApiResponse> apiResponse;
    private CustResponseBuilder custResponseBuilder = new CustResponseBuilder();

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
        setApiResponse(message, cause);
    }

    public BadRequestException(String message) {
        super(message);
        setApiResponse(message);
    }

    public BadRequestException(String message, String extra) {
        super(message);
        setApiResponse(message, extra);
    }

    private void setApiResponse(String message, String extra) {
        apiResponse = custResponseBuilder.buildResponse(HttpStatus.BAD_REQUEST.value(), message, extra);
    }

    private void setApiResponse(String message) {
        apiResponse = custResponseBuilder.buildResponse(HttpStatus.BAD_REQUEST.value(), message);
    }

    private void setApiResponse(String message, Throwable cause) {
        apiResponse = custResponseBuilder.buildResponse(HttpStatus.BAD_REQUEST.value(), message, cause.getCause().getMessage());
    }

}