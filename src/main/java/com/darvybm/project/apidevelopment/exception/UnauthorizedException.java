package com.darvybm.project.apidevelopment.exception;

import com.darvybm.project.apidevelopment.utils.response.ApiResponse;
import com.darvybm.project.apidevelopment.utils.response.CustResponseBuilder;
import lombok.Getter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ResponseEntity<ApiResponse> apiResponse;
    private CustResponseBuilder custResponseBuilder = new CustResponseBuilder();

    public UnauthorizedException() {
        super();
        setApiResponse();
    }

    public UnauthorizedException(String message) {
        super();
        setApiResponse(message);
    }

    private void setApiResponse(String message) {

        apiResponse = custResponseBuilder.buildResponse(HttpStatus.UNAUTHORIZED.value(), message);
    }

    private void setApiResponse() {
        String message = "You are not authorized to perform this action";
        apiResponse = custResponseBuilder.buildResponse(HttpStatus.UNAUTHORIZED.value(), message);
    }
}