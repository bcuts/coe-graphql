package com.sds.act.coe.customer.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sds.act.coe.customer.domain.Address;
import com.sds.act.coe.customer.domain.Customer;
import com.sds.act.coe.customer.graphql.customer.CreateAddressInput;
import com.sds.act.coe.customer.graphql.customer.CreateCustomerInput;
import com.sds.act.coe.customer.graphql.customer.CustomerNotFoundException;
import com.sds.act.coe.customer.graphql.customer.UpdateCustomerInput;
import com.sds.act.coe.customer.repository.AddressRepository;
import com.sds.act.coe.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@NoArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public Customer createCustomer(CreateCustomerInput input) {
        return customerRepository.saveAndFlush(new Customer(input.getName(), input.getEmail()));
    }

    @Transactional
    public Customer updateCustomer(UpdateCustomerInput input) {
        Customer customer = customerRepository
                .findById(input.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(input.getCustomerId()));
        customer.setEmail(input.getEmail());
        customer.setName(input.getName());
        return customer;
    }

    @Transactional
    public Customer deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
        return null;
    }

    @Transactional
    public Address createAddress(CreateAddressInput input){
        Address address = new Address();
        address.setCustomer(customerRepository.findById(input.getCustomerId()).get());
        address.setAddress(input.getAddress());
        address.setPostNumber(input.getPostNumber());
        address.setDetailAddress(input.getDetailAddress());
        return  addressRepository.saveAndFlush(address);

    }

    @Transactional
    public void deleteAddresses(Integer customerId) {
        addressRepository.deleteAllByCustomerCustomerId(customerId);
    }
}
