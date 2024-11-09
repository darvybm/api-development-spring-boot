package com.darvybm.project.apidevelopment.exception;

import com.darvybm.project.apidevelopment.utils.response.ApiResponse;
import com.darvybm.project.apidevelopment.utils.response.CustResponseBuilder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    @Getter
    private ResponseEntity<ApiResponse> apiResponse;
    private CustResponseBuilder custResponseBuilder = new CustResponseBuilder();

    public AppException(Throwable cause) {
        super();
        setApiResponse(cause);

    }
    private void setApiResponse(Throwable cause) {
        String message = "Error occurred while processing request";
        apiResponse = custResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, cause.getMessage());
    }

}