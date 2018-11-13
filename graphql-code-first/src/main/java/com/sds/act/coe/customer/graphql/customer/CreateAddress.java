package com.sds.act.coe.customer.graphql.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddress {
    private int customerId;
    private String postNumber;
    private String address;
    private String detailAddress;
}