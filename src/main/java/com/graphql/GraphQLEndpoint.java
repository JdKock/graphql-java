package com.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.graphql.service.LocatorService;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        LocatorService locatorService = new LocatorService();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(locatorService))
                .build()
                .makeExecutableSchema();
    }

}