package com.graphql;

import com.graphql.service.LocatorService;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import io.leangen.graphql.GraphQLSchemaGenerator;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        LocatorService locatorService = new LocatorService();
        Query query = new Query(locatorService);

        return new GraphQLSchemaGenerator()
                .withOperationsFromSingleton(query)
                .generate();
    }

}