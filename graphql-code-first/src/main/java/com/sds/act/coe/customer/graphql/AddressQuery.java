package com.sds.act.coe.customer.graphql;

import com.sds.act.coe.customer.domain.Address;
import com.sds.act.coe.customer.repository.AddressRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class AddressQuery {

    @Autowired
    private AddressRepository addressRepository;


    @GraphQLQuery
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @GraphQLQuery
    public Address getAddress(@GraphQLArgument(name="id") int id){
        return addressRepository.findById(id).get();
    }

}
