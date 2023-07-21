package com.seujobby.main.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Address {
    private String street;
    private String number;
    private String supplement;
    private String district;
    private String zipCode;
    @ManyToOne
    private City city;

}
