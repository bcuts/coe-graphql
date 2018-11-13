package com.sds.act.coe.customer.graphql;

import com.sds.act.coe.customer.domain.Customer;
import com.sds.act.coe.customer.graphql.customer.CreateCustomer;
import com.sds.act.coe.customer.graphql.customer.CustomerNotFoundException;
import com.sds.act.coe.customer.graphql.customer.UpdateCustomer;
import com.sds.act.coe.customer.repository.CustomerRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class CustomerMutation {
    @Autowired
    private CustomerRepository customerRepository;

    @GraphQLMutation
    public Customer createCustomer(@GraphQLArgument(name="input") CreateCustomer input) {
        return  customerRepository.saveAndFlush(new Customer(input.getName(), input.getEmail()));
    }

    @GraphQLMutation
    public Customer updateCustomer(@GraphQLArgument(name="input") UpdateCustomer input) {
        Customer customer = customerRepository
                .findById(input.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(input.getCustomerId()));
        customer.setEmail(input.getEmail());
        customer.setName(input.getName());
        return customer;
    }

    @GraphQLMutation
    public Customer deleteCustomer(@GraphQLArgument(name="customerId") Integer customerId) {
        customerRepository.deleteById(customerId);
        return null;
    }
}
