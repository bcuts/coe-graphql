package com.sds.act.coe.customer.graphql;

import com.sds.act.coe.customer.domain.Customer;
import com.sds.act.coe.customer.repository.CustomerRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerQuery {

    @Autowired
    private CustomerRepository customerRepository;


    @GraphQLQuery
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GraphQLQuery
    public Customer getCustomer(@GraphQLArgument(name = "id") int id) {
        return customerRepository.findById(id).get();
    }
}
