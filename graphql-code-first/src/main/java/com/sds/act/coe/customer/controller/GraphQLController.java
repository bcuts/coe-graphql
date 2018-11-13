package com.sds.act.coe.customer.controller;

import com.sds.act.coe.customer.graphql.AddressMutation;
import com.sds.act.coe.customer.graphql.AddressQuery;
import com.sds.act.coe.customer.graphql.CustomerMutation;
import com.sds.act.coe.customer.graphql.CustomerQuery;
import com.sds.act.coe.customer.graphql.customer.CustomerResolver;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class GraphQLController {

    private final GraphQL graphQL;

    @Autowired
    public GraphQLController( AddressQuery addressQuery
                            , CustomerQuery customerQuery
                            , AddressMutation addressMutation
                            , CustomerMutation customerMutation
                            , CustomerResolver customerResolver
                           ) {

        //Schema generated from query classes
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withOperationsFromSingletons(customerQuery, addressQuery, customerMutation, addressMutation, customerResolver)
                .withValueMapperFactory(JacksonValueMapperFactory.builder().build())
                .generate();

        graphQL = GraphQL.newGraphQL(schema).build();

    }

    @PostMapping(value = "/graphql", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> indexFromAnnotated(@RequestBody Map<String, Object> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query((String)request.get("query"))
                .variables((Map)request.get("variables"))
                .operationName((String)request.get("operationName"))
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }

}
