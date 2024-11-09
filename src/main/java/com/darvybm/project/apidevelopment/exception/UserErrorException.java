package com.darvybm.project.apidevelopment.exception;


import com.darvybm.project.apidevelopment.utils.response.ApiResponse;
import com.darvybm.project.apidevelopment.utils.response.CustResponseBuilder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserErrorException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    @Getter
    private ResponseEntity<ApiResponse> apiResponse;
    private CustResponseBuilder custResponseBuilder = new CustResponseBuilder();

    public UserErrorException(String message) {
        super();
        setApiResponse(message);
    }

    private void setApiResponse(String message) {
        apiResponse = custResponseBuilder.buildResponse(HttpStatus.BAD_REQUEST.value(), message);
    }

}