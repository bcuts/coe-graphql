package com.sds.act.coe.customer.graphql.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class CustomerNotFoundException extends RuntimeException implements GraphQLError {
    private int customerId;

    @Override
    public String getMessage() {
        return "Customer with ID " + customerId + " could not be found";
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("customerId", customerId);
    }
}
