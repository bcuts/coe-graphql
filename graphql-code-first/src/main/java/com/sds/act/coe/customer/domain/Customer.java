package com.sds.act.coe.customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "customers", schema = "customer")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer extends ResourceSupport implements Serializable {

    @Id
    @Column(name = "customerId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}