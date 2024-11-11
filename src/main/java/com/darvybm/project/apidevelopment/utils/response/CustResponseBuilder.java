package com.darvybm.project.apidevelopment.utils.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustResponseBuilder {

    //Sin message
    public ResponseEntity<ApiResponse> buildResponse( int code, Object data, String extra ) {
        return new ApiResponse.ApiResponseBuilder<>(code)
                .withData(data)
                .withExtra(extra)
                .build();
    }

    //Sin extra y message
    public ResponseEntity<ApiResponse> buildResponse( int code, Object data ) {
        return new ApiResponse.ApiResponseBuilder<>(code)
                .withData(data)
                .build();
    }

    //Solo con el code y message
    public ResponseEntity<ApiResponse> buildResponse( int code, String message ) {
        return new ApiResponse.ApiResponseBuilder<>(code)
                .withMessage(message)
               .build();
    }

    //sin el data
    public ResponseEntity<ApiResponse> buildResponse( int code, String message, String extra ) {
        return new ApiResponse.ApiResponseBuilder<>(code)
                .withMessage(message)
                .withExtra(extra)
               .build();
    }
    //Sin el extra
    public ResponseEntity<ApiResponse> buildResponse( int code, String message, Object data ) {
        return new ApiResponse.ApiResponseBuilder<>(code)
                .withData(data)
                .withMessage(message)
                .build();
    }

    public ResponseEntity<ApiResponse> ok(Object data) {
        return new ApiResponse.ApiResponseBuilder<>(HttpStatus.OK.value())
                .withData(data)
                .build();
    }

    public ResponseEntity<ApiResponse> ok(Object data, String message) {
        return new ApiResponse.ApiResponseBuilder<>(HttpStatus.OK.value())
                .withData(data)
                .withMessage(message)
                .build();
    }

}
