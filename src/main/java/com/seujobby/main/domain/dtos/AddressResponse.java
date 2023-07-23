package com.seujobby.main.domain.dtos;

import lombok.Data;

@Data
public class AddressResponse {
        private String street;
        private String number;
        private String supplement;
        private String district;
        private String zipCode;
        private CityResponse city;
}
