package com.sds.act.coe.customer.graphql.customer;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLScalar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CreateCustomer {
    private String name;
    private String email;


    @GraphQLQuery(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @GraphQLQuery(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}