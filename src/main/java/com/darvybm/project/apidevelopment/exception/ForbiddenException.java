package com.darvybm.project.apidevelopment.exception;

import com.darvybm.project.apidevelopment.utils.response.ApiResponse;
import com.darvybm.project.apidevelopment.utils.response.CustResponseBuilder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private ResponseEntity<ApiResponse> apiResponse;
    private CustResponseBuilder custResponseBuilder = new CustResponseBuilder();

    public ForbiddenException() {
        super();
        setApiResponse();
    }

    public ForbiddenException(String message) {
        super();
        setApiResponse(message);
    }

    private void setApiResponse(String message) {

        apiResponse = custResponseBuilder.buildResponse(HttpStatus.FORBIDDEN.value(), message);
    }

    private void setApiResponse() {
        String message = "You are not allowed to access this resource.";
        apiResponse = custResponseBuilder.buildResponse(HttpStatus.FORBIDDEN.value(), message);
    }

}
