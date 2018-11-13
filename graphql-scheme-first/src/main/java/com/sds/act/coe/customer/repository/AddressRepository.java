package com.sds.act.coe.customer.repository;

import com.sds.act.coe.customer.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findAllByCustomerCustomerId(int customerId);

    void deleteAllByCustomerCustomerId(int customerId);
}
