package com.sds.act.coe.customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "address", schema = "customer")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String postNumber;
    private String address;
    private String detailAddress;

    @ManyToOne
    @JoinColumn(name="customer_id", updatable = false)
    private Customer customer;
}
