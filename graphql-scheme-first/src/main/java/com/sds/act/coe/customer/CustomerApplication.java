package com.sds.act.coe.customer;

import com.sds.act.coe.customer.graphql.MutationResolver;
import com.sds.act.coe.customer.graphql.QueryResolver;
import com.sds.act.coe.customer.graphql.customer.CustomerQueryResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CustomerQueryResolver customerQuery() {
        return new CustomerQueryResolver();
    }

    @Bean
    public QueryResolver query() {
        return new QueryResolver();
    }

    @Bean
    public MutationResolver mutation() {
        return new MutationResolver();
    }
}

