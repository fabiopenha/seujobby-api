package com.seujobby.main.domain.dtos;

import lombok.Data;

@Data
public class CityResponse {
        private Long id;
        private String name;
        private StateResponse state;
        private String sigla;
}
