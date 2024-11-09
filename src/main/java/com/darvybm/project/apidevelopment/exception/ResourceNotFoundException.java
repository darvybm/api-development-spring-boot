package com.darvybm.project.apidevelopment.exception;



import com.darvybm.project.apidevelopment.utils.response.ApiResponse;
import com.darvybm.project.apidevelopment.utils.response.CustResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private CustResponseBuilder custResponseBuilder = new CustResponseBuilder();
    private transient ResponseEntity<ApiResponse> apiResponse;

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super();
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

        setApiResponse();
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public ResponseEntity<ApiResponse> getApiResponse() {
        return apiResponse;
    }

    private void setApiResponse() {
        String message = String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue);

        apiResponse = custResponseBuilder.buildResponse(HttpStatus.NOT_FOUND.value(), message);
    }
}