package com.seujobby.main.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String street;
    private String number;
    private String supplement;
    private String district;
    private String zipCode;
    @ManyToOne(cascade = CascadeType.ALL)
    private City city;

}