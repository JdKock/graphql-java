package com.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeoLocation {

    private String lng;
    private String lat;

}
