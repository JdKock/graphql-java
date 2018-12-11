package com.graphql;

import com.graphql.domain.Atm;
import com.graphql.domain.Office;
import com.graphql.service.LocatorService;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Query  {

    private final LocatorService locatorService;

    @GraphQLQuery
    public List<Office> allOffices() { return locatorService.getOffices(); }

    @GraphQLQuery
    public List<Atm> allAtms() { return locatorService.getAtms(); }

}
