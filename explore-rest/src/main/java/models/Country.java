package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Country {
    private String name;
    private int population;
}
