package com.sds.act.coe.customer;

import com.sds.act.coe.customer.domain.Address;
import com.sds.act.coe.customer.domain.Customer;
import com.sds.act.coe.customer.repository.AddressRepository;
import com.sds.act.coe.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class DataProvider implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    @Transactional
    public void run(String... strings) {
//        customerRepository.save(new Customer("Adam", "Adam@g.com"));
//        customerRepository.save(new Customer("Bdam", "Bdam@g.com"));
//        customerRepository.save(new Customer("Cdam", "Cdam@g.com"));
//        customerRepository.save(new Customer("Ddam", "Ddam@g.com"));
//        customerRepository.save(new Customer("Edam", "Edam@g.com"));
//        customerRepository.save(new Customer("Fdam", "Fdam@g.com"));
//        customerRepository.save(new Customer("Gdam", "Gdam@g.com"));
//        customerRepository.flush();
//
//        Customer customer = new Customer();
//        customer.setCustomerId(1);
//
//        Address s = new Address();
//        s.setCustomer(customer);
//        s.setAddress("1122121");
//        s.setPostNumber("1214123213");
//        s.setDetailAddress("fdjsalkfdjlaeskf");
//        addressRepository.saveAndFlush(s);
    }
}
