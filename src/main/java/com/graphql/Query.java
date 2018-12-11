package com.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.graphql.service.LocatorService;
import com.graphql.domain.Atm;
import com.graphql.domain.Office;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Query implements GraphQLRootResolver {

    private final LocatorService locatorService;

    //@GraphQLQuery
    public List<Office> allOffices() { return locatorService.getOffices(); }

    //@GraphQLQuery
    public List<Atm> allAtms() { return locatorService.getAtms(); }

}
