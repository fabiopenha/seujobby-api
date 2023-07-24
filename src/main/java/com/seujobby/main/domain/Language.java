package com.seujobby.main.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Language {
    private String idiom;
}
