package com.sds.act.coe.customer.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sds.act.coe.customer.domain.Address;
import com.sds.act.coe.customer.domain.Customer;
import com.sds.act.coe.customer.repository.AddressRepository;
import com.sds.act.coe.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddress(int id) {
        return addressRepository.findById(id).get();
    }

}