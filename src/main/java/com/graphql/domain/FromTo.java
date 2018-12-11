package com.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FromTo {

    private String hourFrom;
    private String hourTo;
}
