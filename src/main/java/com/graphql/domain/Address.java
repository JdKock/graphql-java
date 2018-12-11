package com.graphql.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Address {

    private String postalcode;
    private String street;
    private GeoLocation geoLocation;
    private String housenumber;
    private String suffix;
    private String city;

}
