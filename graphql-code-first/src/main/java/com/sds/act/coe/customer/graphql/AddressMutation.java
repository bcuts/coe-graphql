package com.sds.act.coe.customer.graphql;

import com.sds.act.coe.customer.domain.Address;
import com.sds.act.coe.customer.graphql.customer.CreateAddress;
import com.sds.act.coe.customer.repository.AddressRepository;
import com.sds.act.coe.customer.repository.CustomerRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class AddressMutation {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GraphQLMutation
    public Address createAddress(@GraphQLArgument(name="input") CreateAddress input){
        Address address = new Address();
        address.setCustomer(customerRepository.findById(input.getCustomerId()).get());
        address.setAddress(input.getAddress());
        address.setPostNumber(input.getPostNumber());
        address.setDetailAddress(input.getDetailAddress());
        return  addressRepository.saveAndFlush(address);

    }

    @GraphQLMutation
    public void deleteAddresses(@GraphQLArgument(name="customerId") Integer customerId) {
        addressRepository.deleteAllByCustomerCustomerId(customerId);
    }
}
