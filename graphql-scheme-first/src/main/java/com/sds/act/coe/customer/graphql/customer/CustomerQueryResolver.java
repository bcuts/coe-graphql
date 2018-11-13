package com.sds.act.coe.customer.graphql.customer;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sds.act.coe.customer.domain.Address;
import com.sds.act.coe.customer.domain.Customer;
import com.sds.act.coe.customer.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CustomerQueryResolver implements GraphQLResolver<Customer> {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddresses(Customer customer) {
        return addressRepository.findAllByCustomerCustomerId(customer.getCustomerId());
    }
}