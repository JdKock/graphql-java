package com.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.graphql.domain.Atm;
import com.graphql.domain.Office;
import com.graphql.service.LocatorService;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Query implements GraphQLRootResolver {

    private final LocatorService locatorService;

    public List<Office> allOffices() { return locatorService.getOffices(); }

    public List<Atm> allAtms() { return locatorService.getAtms(); }

}
