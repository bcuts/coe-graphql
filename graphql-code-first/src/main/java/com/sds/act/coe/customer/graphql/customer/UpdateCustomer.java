package com.sds.act.coe.customer.graphql.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomer {
    private int customerId;
    private String name;
    private String email;
}