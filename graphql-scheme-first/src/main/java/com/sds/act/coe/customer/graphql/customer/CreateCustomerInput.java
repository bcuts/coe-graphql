package com.sds.act.coe.customer.graphql.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerInput {
    private String name;
    private String email;
}