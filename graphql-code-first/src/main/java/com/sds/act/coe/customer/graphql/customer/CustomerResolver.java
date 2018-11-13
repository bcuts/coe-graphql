package com.sds.act.coe.customer.graphql.customer;
import com.sds.act.coe.customer.domain.Address;
import com.sds.act.coe.customer.domain.Customer;
import com.sds.act.coe.customer.repository.AddressRepository;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class CustomerResolver {

    @Autowired
    private AddressRepository addressRepository;

    @GraphQLQuery
    public List<Address> addresses(@GraphQLContext Customer customer) {
        return addressRepository.findAllByCustomerCustomerId(customer.getCustomerId());
    }
}