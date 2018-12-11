package com.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OpeningHours {

    private String dayOfWeek;
    private List<FromTo> hours;

}
