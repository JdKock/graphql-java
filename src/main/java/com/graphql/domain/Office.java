package com.graphql.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties
public class Office {

    private String faxNumber;
    private List<String> openingInfo;
    private List<OpeningHours> openingHours;
    private Address address;
    private String telephoneNumber;
    private String name;
    private String pir;
    private String type;
    private boolean lockers;
    private String info;

}
