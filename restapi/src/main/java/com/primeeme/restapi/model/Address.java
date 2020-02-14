
package com.primeeme.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Address {
    private final String address1;
    private final String address2;
    private final String city;
    private final String state;
    private final Integer postal;
}

